package com.dm.springbootjpapostgresql.model.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaxInvoiceLine {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "F_COUNT")
	private int count;

	@JsonProperty("item")
	@Embedded
	private ItemTaxInvoice item;

	public double totalAmount() {
		return getCount() * getItem().getPrice();
	}

}

