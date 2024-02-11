package com.dm.springbootjpapostgresql.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dm.springbootjpapostgresql.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
    
}
