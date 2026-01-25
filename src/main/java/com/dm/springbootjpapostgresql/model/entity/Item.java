package com.dm.springbootjpapostgresql.model.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
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
public class Item {

	@Id
	@GeneratedValue
	private Long itemId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private double price;
}