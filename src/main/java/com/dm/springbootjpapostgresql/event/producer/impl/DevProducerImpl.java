package com.dm.springbootjpapostgresql.event.producer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.dm.springbootjpapostgresql.event.producer.DevProducer;

@Service
public class DevProducerImpl implements DevProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendToConsole(String text) {
        // ActiveMQ creates the queue automatically if it doesn't exist
        jmsTemplate.convertAndSend("dev.test.queue", text);
        System.out.println("Message sent! Check http://localhost:8161/admin/queues.jsp");
    }
}
