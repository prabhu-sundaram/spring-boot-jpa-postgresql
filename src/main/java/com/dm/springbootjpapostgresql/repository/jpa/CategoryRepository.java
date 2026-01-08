package com.dm.springbootjpapostgresql.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dm.springbootjpapostgresql.model.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
