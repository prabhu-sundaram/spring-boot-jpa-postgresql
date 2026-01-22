package com.dm.springbootjpapostgresql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import com.dm.springbootjpapostgresql.dto.UserOrder;

@RestController
@RequestMapping("/api/messages")
public class MessageTriggerController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/send-order")
    public String sendOrder(@RequestBody UserOrder order) {
        // "order-queue" is the name that will appear in your Docker ActiveMQ console
        jmsTemplate.convertAndSend("order-queue", order);
        
        return "Order sent to ActiveMQ successfully!";
    }
}
