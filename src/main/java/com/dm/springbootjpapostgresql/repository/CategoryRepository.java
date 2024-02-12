package com.dm.springbootjpapostgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dm.springbootjpapostgresql.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
