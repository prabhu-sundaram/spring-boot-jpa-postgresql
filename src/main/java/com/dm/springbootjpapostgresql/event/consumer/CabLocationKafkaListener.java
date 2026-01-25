package com.dm.springbootjpapostgresql.event.consumer;

public interface CabLocationKafkaListener {

    public void cabLocation(String location);
}
