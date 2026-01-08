package com.dm.springbootjpapostgresql.model.entity.pojo.inheritance.MappedSuperclass;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Person3 {

    @Id
    private long personId;

    private String name;

    public Person3() {
    }

    public Person3(long personId, String name) {
        this.personId = personId;
        this.name = name;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
