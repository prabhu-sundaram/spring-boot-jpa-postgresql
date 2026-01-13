package com.dm.springbootjpapostgresql.model.entity.pojo.inheritance.TablePerClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Vehicle {
    @Id
    private Long vehicleId;

    private String manufacturer;

    public Vehicle() {
    }

    public Vehicle(Long vehicleId, String manufacturer) {
        this.vehicleId = vehicleId;
        this.manufacturer = manufacturer;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

}
