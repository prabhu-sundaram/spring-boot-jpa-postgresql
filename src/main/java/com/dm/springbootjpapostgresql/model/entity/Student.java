package com.dm.springbootjpapostgresql.model.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(
    name = "tbl_student",
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
	
    @Column(name = "age")
    private Integer age;

    @Column(name = "birth_date")
    private LocalDate birthDate;  

    @Column(name = "email_address",nullable = false, unique = true)
    private String email;

    // @Embedded
    // private Guardian guardian;

    @Column(name = "status",columnDefinition = "number default 1")
    private Integer status;

    @Column(name = "active",columnDefinition = "boolean default true")
    private Boolean active;
        
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id", nullable = false)
    private School school;

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
