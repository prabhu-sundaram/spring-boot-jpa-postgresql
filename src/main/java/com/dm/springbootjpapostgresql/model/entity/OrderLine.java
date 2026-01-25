package com.dm.springbootjpapostgresql.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderLine {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "F_COUNT")
	private Integer count;

	@ManyToOne
	private Item item;

}