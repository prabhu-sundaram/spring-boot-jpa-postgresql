package com.dm.springbootjpapostgresql.event.producer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.dm.springbootjpapostgresql.constant.AppConstant;
import com.dm.springbootjpapostgresql.event.producer.CabLocationKafkaService;

@Service
public class CabLocationKafkaServiceImpl implements CabLocationKafkaService {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    public boolean updateLocation(String location) {
        kafkaTemplate.send(AppConstant.CAB_LOCATION, location);
        return true;
    }
}
