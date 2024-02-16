package com.dm.springbootjpapostgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dm.springbootjpapostgresql.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}