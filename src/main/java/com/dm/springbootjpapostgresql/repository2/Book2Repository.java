package com.dm.springbootjpapostgresql.repository2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dm.springbootjpapostgresql.pojo.inheritance.SingleTable.Book2;

@Repository
public interface Book2Repository extends JpaRepository<Book2,Long>{
    
}
