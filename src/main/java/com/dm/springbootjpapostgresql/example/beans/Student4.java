package com.dm.springbootjpapostgresql.example.beans;

import java.io.Serializable;
import java.util.Objects;

public class Student4 implements Serializable {
    private String name;
    private int age;

    public Student4(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Student4 student4 = (Student4) o;
        return age == student4.age && Objects.equals(name, student4.name);
    }
}