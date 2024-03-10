package com.dm.springbootjpapostgresql.repository2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dm.springbootjpapostgresql.pojo.inheritance.MappedSuperclass.Person3;

@Repository
public interface Person3Repository extends JpaRepository<Person3,Long>{
    
}
