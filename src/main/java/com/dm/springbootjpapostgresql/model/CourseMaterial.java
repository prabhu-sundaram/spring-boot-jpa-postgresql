package com.dm.springbootjpapostgresql.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@ToString(exclude = "course")
public class CourseMaterial {
    @Id
    @SequenceGenerator(
        name = "course_material_sequence",
        sequenceName = "course_material_sequence",
        allocationSize = 1
    )   
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "course_material_sequence")           
    private Long courseMaterialId;
    private String url;

    @OneToOne(
        cascade =CascadeType.ALL
        ,fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", referencedColumnName = "courseId",nullable = false)
    private Course course;


}
