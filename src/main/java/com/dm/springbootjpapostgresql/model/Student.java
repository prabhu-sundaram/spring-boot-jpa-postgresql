package com.dm.springbootjpapostgresql.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
    name = "student",
    uniqueConstraints = @UniqueConstraint(
        name="emailid_unique",
        columnNames = "email_address"
    )

    )

public class Student {
    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence")
    private Long studentId;

    @Column(nullable = false)    
	private String firstName;

    @Column(nullable = false)
	private String lastName;
	
    @Column(name = "email_address",nullable = false, unique = true)
    private String email;

    private String guardianName;
    private String guardianEmail;
    private String guardianMobile;


    public Student(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(String firstName, String lastName, String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
     /* 
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    */
}
