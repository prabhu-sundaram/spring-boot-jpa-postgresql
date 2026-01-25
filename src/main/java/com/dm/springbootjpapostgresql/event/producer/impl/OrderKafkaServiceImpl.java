package com.dm.springbootjpapostgresql.event.producer.impl;


import java.util.Date;
import java.util.concurrent.CompletableFuture;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.dm.springbootjpapostgresql.event.producer.OrderKafkaService;
import com.dm.springbootjpapostgresql.model.entity.Customer;
import com.dm.springbootjpapostgresql.model.entity.Item;
import com.dm.springbootjpapostgresql.model.entity.Order;
import com.dm.springbootjpapostgresql.repository.jpa.CustomerRepository;
import com.dm.springbootjpapostgresql.repository.jpa.ItemRepository;
import com.dm.springbootjpapostgresql.repository.jpa.OrderRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderKafkaServiceImpl implements OrderKafkaService {

	private final OrderRepository orderRepository;
	private final CustomerRepository customerRepository;
	private final ItemRepository itemRepository;
	private final OrderMetadataService orderMetadataService;

	private final KafkaTemplate<String, Order> kafkaTemplate;

	public OrderKafkaServiceImpl(OrderRepository orderRepository, 
								ItemRepository itemRepository,
								CustomerRepository customerRepository,
								OrderMetadataService orderMetadataService,
								KafkaTemplate<String, Order> kafkaTemplate) {
		super();
		this.orderRepository = orderRepository;
		this.itemRepository = itemRepository;
		this.customerRepository = customerRepository;
		this.orderMetadataService = orderMetadataService;
		this.kafkaTemplate = kafkaTemplate;
	}

	@Transactional
	public Order order(Order order) {
		if (order.getNumberOfLines() == 0) {
			throw new IllegalArgumentException("No order lines!");
		}
		
        if (order.getCustomer() != null && order.getCustomer().getCustomerId() != null) {
            Customer customer = customerRepository.findById(order.getCustomer().getCustomerId())
                    .orElseThrow(() -> new EntityNotFoundException("Customer not found"));
            order.setCustomer(customer);
        }

        order.getOrderLine().forEach(line -> {
            if (line.getItem() != null && line.getItem().getItemId() != null) {
                // Fetch the full Item entity from the DB
                Item fullItem = itemRepository.findById(line.getItem().getItemId())
                        .orElseThrow(() -> new EntityNotFoundException("Item not found: " + line.getItem().getItemId()));
                
                // Link the full item (containing Name and Price) to the order line
                line.setItem(fullItem);
            }
        });
        
        if (order.getShippingAddress() == null || order.getBillingAddress() == null) {
            throw new IllegalArgumentException("Shipping and Billing addresses are required");
        }
		order.setUpdated(new Date());
		Order savedOrder = orderRepository.save(order);
		
		//fireOrderCreatedEvent(order);
		
		TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
            @Override
            public void afterCommit() {
                fireOrderCreatedEvent(savedOrder);
            }
		});
            
		return savedOrder;
	}

	private void fireOrderCreatedEvent(Order order) {
		//kafkaTemplate.send("order", order.getId() + "created", order);
		
		String key = order.getId() + "created";
	    
	    CompletableFuture<SendResult<String, Order>> future = kafkaTemplate.send("order", key, order);

	    future.whenComplete((result, ex) -> {
	        if (ex == null) {
	            // Success logic
	            RecordMetadata metadata = result.getRecordMetadata();
	            log.info("Message sent successfully for Order ID: {} | Topic: {} | Partition: {} | Offset: {}", 
	                     order.getId(),
	                     metadata.topic(),
	                     metadata.partition(),
	                     metadata.offset());
	            orderMetadataService.saveEventLog(order.getId(), metadata.partition(), metadata.offset());
	        } else {
	            // Failure logic
	            log.error("Unable to send and log message for Order ID: {} due to: {}", order.getId(), ex.getMessage());
	        }
	    });		
	}

	public double getPrice(long orderId) {
		return orderRepository.findById(orderId).get().totalPrice();
	}

}

