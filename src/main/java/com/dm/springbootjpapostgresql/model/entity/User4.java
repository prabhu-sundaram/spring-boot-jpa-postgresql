package com.dm.springbootjpapostgresql.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name="user4")
@Getter
@Setter
public class User4 {

    @Id
    private Integer id;
    private String userName;
    private String password;
}
