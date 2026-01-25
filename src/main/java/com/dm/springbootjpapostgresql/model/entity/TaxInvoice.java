package com.dm.springbootjpapostgresql.model.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaxInvoice {

	@Id
	private Long id;

	@Embedded
	private CustomerTaxInvoice customer;

	private Date updated;

	@Embedded
	private CustomerAddress billingAddress;

	@JsonProperty("orderLine")
	@OneToMany(cascade = CascadeType.ALL)
	private List<TaxInvoiceLine> invoiceLine;

	@Transient
	public void setOrderLine(List<TaxInvoiceLine> orderLine) {
		this.invoiceLine = orderLine;
	}

	public void addLine(int count, ItemTaxInvoice item) {
		this.invoiceLine.add(new TaxInvoiceLine(null, count, item));
	}

	public int getNumberOfLines() {
		return invoiceLine.size();
	}

	public double totalAmount() {
		return invoiceLine.stream().map((ol) -> ol.getCount() * ol.getItem().getPrice()).reduce(0.0,
				(d1, d2) -> d1 + d2);
	}

}

