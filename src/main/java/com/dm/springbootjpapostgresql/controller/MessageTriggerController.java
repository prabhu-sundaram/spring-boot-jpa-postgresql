package com.dm.springbootjpapostgresql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dm.springbootjpapostgresql.dto.UserOrder;
import com.dm.springbootjpapostgresql.event.producer.OrderProducer;
import com.dm.springbootjpapostgresql.event.producer.DevProducer;

@RestController
@RequestMapping("/api/messages")
public class MessageTriggerController {

    @Autowired
    DevProducer devProducer;
    @Autowired
    OrderProducer orderProducer;

    @PostMapping("/send-text")
    public String sendText(@RequestParam String message) {
        devProducer.sendToConsole(message);
        return "Message sent to ActiveMQ successfully!";
    }

    @PostMapping("/send-order")
    public String sendOrder(@RequestBody UserOrder order) {
        orderProducer.sendOrder(order);
        return "Order sent to ActiveMQ successfully!";
    }
}
