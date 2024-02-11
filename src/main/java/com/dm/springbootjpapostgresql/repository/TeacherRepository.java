package com.dm.springbootjpapostgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dm.springbootjpapostgresql.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    
}
