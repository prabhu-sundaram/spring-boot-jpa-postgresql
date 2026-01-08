package com.dm.springbootjpapostgresql.repository.jpa.montaji;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dm.springbootjpapostgresql.model.entity.montaji.Container;

@Repository
public interface ContainerRepository extends JpaRepository<Container, Long> {
    
}
