package com.dm.springbootjpapostgresql.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dm.springbootjpapostgresql.model.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}