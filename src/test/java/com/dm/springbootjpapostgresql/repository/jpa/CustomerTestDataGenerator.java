package com.dm.springbootjpapostgresql.repository.jpa;

import org.springframework.stereotype.Component;

import com.dm.springbootjpapostgresql.model.entity.Customer;
import com.dm.springbootjpapostgresql.repository.jpa.CustomerRepository;

import jakarta.annotation.PostConstruct;

@Component
public class CustomerTestDataGenerator {

	private final CustomerRepository customerRepository;

	public CustomerTestDataGenerator(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@PostConstruct
	public void generateTestData() {
		customerRepository
			.save(new Customer(null,"Eberhard", "Wolff", "eberhard.wolff@gmail.com"));
		customerRepository
			.save(new Customer(null,"Rod", "Johnson", "rod@somewhere.com"));
	}

}