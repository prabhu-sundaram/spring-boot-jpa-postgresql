package com.dm.springbootjpapostgresql.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dm.springbootjpapostgresql.model.entity.Book;
import com.dm.springbootjpapostgresql.repository.jpa.BookRepository;

@Service
public class BookServices {

	@Autowired
	BookRepository bookRepository;
	//Adding Book
	public Book addBook(Book book) {
	    bookRepository.save(book);
	    return book;
	}
	//GetAll Customers
	public List<Book> getBooks(){
		List<Book> book = new ArrayList<>();
		bookRepository.findAll().forEach(books -> book.add(books));
		return book;
	}
	//Get Customer findById
	public Book getBookById(Integer id) {
		return bookRepository.findById(id).get();
	}
}
