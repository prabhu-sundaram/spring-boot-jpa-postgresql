package com.dm.springbootjpapostgresql.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.springbootjpapostgresql.model.entity.Customer;
import com.dm.springbootjpapostgresql.model.entity.Item;
import com.dm.springbootjpapostgresql.model.entity.Order;
import com.dm.springbootjpapostgresql.repository.jpa.CustomerRepository;
import com.dm.springbootjpapostgresql.repository.jpa.OrderRepository;
import com.dm.springbootjpapostgresql.repository.jpa.ItemRepository;
import com.dm.springbootjpapostgresql.event.producer.OrderKafkaService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderRepository orderRepository;
    private final OrderKafkaService orderKafkaService;
    private final CustomerRepository customerRepository;
    private final ItemRepository itemRepository;

    // Made public to avoid CGLIB proxy errors
    public OrderController(OrderKafkaService orderKafkaService, OrderRepository orderRepository,
                           CustomerRepository customerRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.itemRepository = itemRepository;
        this.orderKafkaService = orderKafkaService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Order>> orderList() {
        return ResponseEntity.ok(orderRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> get(@PathVariable("id") Long id) {
        return orderRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Order> post(@RequestBody Order order) {
        Order savedOrder = orderKafkaService.order(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        if (!orderRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        orderRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/items")
    public ResponseEntity<Iterable<Item>> getItems() {
        return ResponseEntity.ok(itemRepository.findAll());
    }

    @GetMapping("/customers")
    public ResponseEntity<Iterable<Customer>> getCustomers() {
        return ResponseEntity.ok(customerRepository.findAll());
    }
}
