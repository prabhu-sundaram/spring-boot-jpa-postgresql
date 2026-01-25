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
public class Shipment {

	@Id
	private Long id;

	@Embedded
	private CustomerShipping customer;

	private Date updated;

	@Embedded
	private CustomerAddress shippingAddress;

	@JsonProperty("orderLine")
	@OneToMany(cascade = CascadeType.ALL)
	private List<ShipmentLine> shipmentLine;

	@Transient
	public void setOrderLine(List<ShipmentLine> orderLine) {
		this.shipmentLine = orderLine;
	}

	public int getNumberOfLines() {
		return shipmentLine.size();
	}

}
