package com.dm.springbootjpapostgresql.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.dm.springbootjpapostgresql.dto.UserOrder;

@Component
public class OrderConsumer {

    // destination matches the queue name used in the producer
    @JmsListener(destination = "order-queue")
    public void receiveOrder(UserOrder order) {
        System.out.println("CONSUMER RECEIVED DATA:");
        System.out.println("Order ID: " + order.orderId());
        System.out.println("Product: " + order.productName());
        System.out.println("Quantity: " + order.quantity());
    }
}
