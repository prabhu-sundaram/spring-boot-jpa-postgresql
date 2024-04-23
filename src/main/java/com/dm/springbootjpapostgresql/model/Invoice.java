package com.dm.springbootjpapostgresql.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Invoice {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Double amount;
	private Double finalAmount;
	@Column(name = "invoice_number")
	private String number;
	private String receivedDate;
	private String type;
	private String vendor;
	private String comments;
}
