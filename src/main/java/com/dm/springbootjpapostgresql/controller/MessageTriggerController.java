package com.dm.springbootjpapostgresql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import com.dm.springbootjpapostgresql.dto.UserOrder;
import com.dm.springbootjpapostgresql.event.producer.OrderProducer;

@RestController
@RequestMapping("/api/messages")
public class MessageTriggerController {

    @Autowired
    OrderProducer orderProducer;

    @PostMapping("/send-order")
    public String sendOrder(@RequestBody UserOrder order) {
        orderProducer.sendOrder(order);
        return "Order sent to ActiveMQ successfully!";
    }
}
