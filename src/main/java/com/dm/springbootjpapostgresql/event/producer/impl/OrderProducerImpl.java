package com.dm.springbootjpapostgresql.event.producer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.dm.springbootjpapostgresql.dto.UserOrder;
import com.dm.springbootjpapostgresql.event.producer.OrderProducer;

@Service
public class OrderProducerImpl implements OrderProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendOrder(UserOrder order) {
        // "order-queue" is the name that will appear in your Docker ActiveMQ console
        jmsTemplate.convertAndSend("order-queue", order);
    }    
}
