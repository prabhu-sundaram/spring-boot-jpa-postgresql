package com.dm.springbootjpapostgresql.repository2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dm.springbootjpapostgresql.pojo.inheritance.SingleTable.MyProduct;

@Repository
public interface MyProductRepository extends JpaRepository<MyProduct,Long>{
    
}
