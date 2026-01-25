package com.dm.springbootjpapostgresql.event.producer;

public interface CabLocationKafkaService {

    public boolean updateLocation(String location);
}
