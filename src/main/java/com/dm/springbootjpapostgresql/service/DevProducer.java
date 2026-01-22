package com.dm.springbootjpapostgresql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class DevProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendToConsole(String text) {
        // ActiveMQ creates the queue automatically if it doesn't exist
        jmsTemplate.convertAndSend("dev.test.queue", text);
        System.out.println("Message sent! Check http://localhost:8161/admin/queues.jsp");
    }
}
