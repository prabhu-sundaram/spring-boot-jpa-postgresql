package com.dm.springbootjpapostgresql.repository.montaji;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dm.springbootjpapostgresql.model.montaji.Container;

@Repository
public interface ContainerRepository extends JpaRepository<Container, Long> {
    
}
