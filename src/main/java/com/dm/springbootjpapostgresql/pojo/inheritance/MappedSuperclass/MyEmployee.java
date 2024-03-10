package com.dm.springbootjpapostgresql.pojo.inheritance.MappedSuperclass;

import jakarta.persistence.Entity;

@Entity
public class MyEmployee extends Person3 {
    private String company;

    public MyEmployee() {
        super(); // Call to the superclass default constructor
    }
    
    public MyEmployee(long personId, String name, String company) {
        super(personId, name);
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

}
