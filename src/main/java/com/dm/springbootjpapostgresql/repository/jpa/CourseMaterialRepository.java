package com.dm.springbootjpapostgresql.repository.jpa;

import org.springframework.stereotype.Repository;

import com.dm.springbootjpapostgresql.model.entity.CourseMaterial;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long>{
    
}
