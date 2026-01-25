package com.dm.springbootjpapostgresql.model.entity;


import java.util.Date;
import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "ORDERTABLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Customer customer;

	@Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
	private Date updated;

	@Embedded
	@AttributeOverrides({ 
			@AttributeOverride(name = "street", column = @Column(name = "SHIPPING_STREET")),
			@AttributeOverride(name = "zip", column = @Column(name = "SHIPPING_ZIP")),
			@AttributeOverride(name = "city", column = @Column(name = "SHIPPING_CITY")) })
	private CustomerAddress shippingAddress;

	@Embedded
	@AttributeOverrides({ 
			@AttributeOverride(name = "street", column = @Column(name = "BILLING_STREET")),
			@AttributeOverride(name = "zip", column = @Column(name = "BILLING_ZIP")),
			@AttributeOverride(name = "city", column = @Column(name = "BILLING_CITY")) })
	private CustomerAddress billingAddress;

	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderLine> orderLine;

	@PrePersist
    @PreUpdate
    private void onUpdate() {
        updated = new Date();
    }	
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	@ToString.Exclude // Prevents infinite loops
	@EqualsAndHashCode.Exclude
	private OrderEventLog orderEventLog;	

	public void addLine(int count, Item item) {
		this.orderLine.add(new OrderLine(null, count, item));
	}

	public int getNumberOfLines() {
		return orderLine.size();
	}

	public double totalPrice() {
		return orderLine.stream().map((ol) -> ol.getCount() * ol.getItem().getPrice()).reduce(0.0, (d1, d2) -> d1 + d2);
	}

}
