package com.dm.springbootjpapostgresql.example.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Getter @Setter @NoArgsConstructor
@Data
public class User {
    private @Id Long id; // will be set when persisting
    //private @Id @Setter(AccessLevel.PROTECTED) Long id;
	//private @Id @Setter Long id;

    private String firstName;
    private String lastName;
    private int age;
    
//    public User(String firstName, String lastName, int age) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age = age;
//    }    
}
