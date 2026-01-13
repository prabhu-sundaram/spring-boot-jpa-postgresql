package com.dm.springbootjpapostgresql.model.entity.pojo.inheritance.PolymorphicQueries;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

@Entity
@Polymorphism(type = PolymorphismType.EXPLICIT)
public class Bag implements Item {

    @Id
    private Long bagId;

    private String type;

    public Bag(Long bagId, String type) {
        this.bagId = bagId;
        this.type = type;
    }

    public Long getBagId() {
        return bagId;
    }

    public void setBagId(Long bagId) {
        this.bagId = bagId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
