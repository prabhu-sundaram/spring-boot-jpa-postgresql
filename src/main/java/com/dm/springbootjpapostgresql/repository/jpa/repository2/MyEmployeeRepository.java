package com.dm.springbootjpapostgresql.repository.jpa.repository2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dm.springbootjpapostgresql.model.entity.pojo.inheritance.MappedSuperclass.MyEmployee;

@Repository
public interface MyEmployeeRepository extends JpaRepository<MyEmployee,Long>{
    
}
