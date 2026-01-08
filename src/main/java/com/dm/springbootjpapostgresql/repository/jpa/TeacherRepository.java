package com.dm.springbootjpapostgresql.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dm.springbootjpapostgresql.model.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    
}
