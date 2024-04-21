package com.dm.springbootjpapostgresql.example.beans;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Employee2 {

    private Long id;
    private String name;
    private BigDecimal salary;
    private LocalDateTime createdDate;

    public Employee2() {
    }

    public Employee2(Long id, String name, BigDecimal salary, LocalDateTime createdDate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.createdDate = createdDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Employee2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", createdDate=" + createdDate +
                '}';
    }
}