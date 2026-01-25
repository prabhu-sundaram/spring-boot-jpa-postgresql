package com.dm.springbootjpapostgresql.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerTaxInvoice {

	@Column(nullable = false)
	private Long customerId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String firstname;

	@Column(nullable = false)
	@Email
	private String email;

}