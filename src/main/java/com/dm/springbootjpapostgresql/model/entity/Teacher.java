package com.dm.springbootjpapostgresql.model.entity;

import java.util.List;

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
public class Teacher {
    @Id
    @SequenceGenerator(
        name = "teacher_sequence",
        sequenceName = "teacher_sequence",
        allocationSize = 1
    )    
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "teacher_sequence")    
    private Long teacherId;
    private String firstName;
    private String lastName;

//     @OneToMany
//     (
//         cascade=CascadeType.ALL
//     )
//     @JoinColumn(name = "teacher_id")
//     private List<Course> courses;
    
}
