package com.dm.springbootjpapostgresql.event.consumer.impl;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.dm.springbootjpapostgresql.event.consumer.CabLocationKafkaListener;

@Service
public class CabLocationKafkaListenerImpl implements CabLocationKafkaListener {

    //@KafkaListener(topics = "cab-location", groupId = "user-group")
    @KafkaListener(topics = "cab-location", containerFactory = "userFactory")
    public void cabLocation(String location) {
        System.out.println(location);
    }
}
