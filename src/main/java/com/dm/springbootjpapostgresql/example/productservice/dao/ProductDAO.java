package com.dm.springbootjpapostgresql.example.productservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dm.springbootjpapostgresql.example.productservice.entity.ProductEntity;
public interface ProductDAO extends JpaRepository<ProductEntity, Integer>
{
}