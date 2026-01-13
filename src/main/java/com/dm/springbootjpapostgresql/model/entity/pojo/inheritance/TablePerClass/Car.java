package com.dm.springbootjpapostgresql.model.entity.pojo.inheritance.TablePerClass;

import jakarta.persistence.Entity;

@Entity
public class Car extends Vehicle {
    private String engine;

    public Car() {
    }

    public Car(Long vehicleId, String manufacturer, String engine) {
        super(vehicleId, manufacturer);
        this.engine = engine;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

}
