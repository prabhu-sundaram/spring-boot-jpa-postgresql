package com.dm.springbootjpapostgresql.repository.montaji;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dm.springbootjpapostgresql.model.montaji.RequestCPIP;

@Repository
public interface RequestCPIPRepository extends JpaRepository<RequestCPIP, String> {
    
}
