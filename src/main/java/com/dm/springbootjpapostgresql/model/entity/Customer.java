package com.dm.springbootjpapostgresql.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

	@Id
	@GeneratedValue
	private Long customerId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String firstname;

	@Column(nullable = false)
	@Email
	private String email;
	
//	@Column(nullable = false)
//	private String street;
//	
//	@Column(nullable = false)
//	private String city;	

}
