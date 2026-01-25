package com.dm.springbootjpapostgresql.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemTaxInvoice {

	@Column(nullable = false)
	private Long itemId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private double price;

}