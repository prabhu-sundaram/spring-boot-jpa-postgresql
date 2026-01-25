package com.dm.springbootjpapostgresql.event.consumer.impl;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.dm.springbootjpapostgresql.dto.UserOrder;
import com.dm.springbootjpapostgresql.event.consumer.OrderConsumer;

@Component
public class OrderConsumerImpl implements OrderConsumer {

    // destination matches the queue name used in the producer
    @JmsListener(destination = "order-queue")
    public void receiveOrder(UserOrder order) {
        System.out.println("CONSUMER RECEIVED DATA:");
        System.out.println("Order ID: " + order.orderId());
        System.out.println("Product: " + order.productName());
        System.out.println("Quantity: " + order.quantity());
    }
}
