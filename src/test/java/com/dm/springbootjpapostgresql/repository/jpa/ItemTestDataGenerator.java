package com.dm.springbootjpapostgresql.repository.jpa;

import org.springframework.stereotype.Component;

import com.dm.springbootjpapostgresql.model.entity.Item;

import jakarta.annotation.PostConstruct;

@Component
public class ItemTestDataGenerator {

	private final ItemRepository itemRepository;

	public ItemTestDataGenerator(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@PostConstruct
	public void generateTestData() {
		itemRepository.save(new Item(null, "iPod", 42.0));
		itemRepository.save(new Item(null, "iPod touch", 21.0));
		itemRepository.save(new Item(null, "iPod nano", 1.0));
		itemRepository.save(new Item(null, "Apple TV", 100.0));
	}

}
