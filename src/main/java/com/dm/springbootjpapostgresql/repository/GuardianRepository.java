package com.dm.springbootjpapostgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dm.springbootjpapostgresql.model.Guardian;

public interface GuardianRepository extends JpaRepository<Guardian,Long>{

    
}