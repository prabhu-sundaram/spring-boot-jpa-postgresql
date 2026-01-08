package com.dm.springbootjpapostgresql.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.springbootjpapostgresql.model.entity.Book;
import com.dm.springbootjpapostgresql.service.BookServices;
import lombok.Getter;
import lombok.Setter;

@Controller
//@RestController
//@RequestMapping("/books")
public class BookController {
	@Autowired
	BookServices bookServices;
//	@PostMapping("/addBook")
	@MutationMapping("createBook")
	public Book addBook(@Argument BookInput book) {
		Book b = new Book();
		b.setTitle(book.getTitle());
		b.setDescription(book.getDescription());
		b.setAuthor(book.getAuthor());
		b.setPrice(book.getPrice());
		b.setPages(book.getPages());
		return this.bookServices.addBook(b);
	}
//	@GetMapping("/getBooks")
	@QueryMapping("allBooks")
	public List<Book> getBooks(){
		return bookServices.getBooks();
	}
//	@GetMapping("/getBook/{id}")
	@QueryMapping("getBook")
	public Book getBookById(@Argument int id){
		return bookServices.getBookById(id);
	}
}
class BookInput{
	private String title;
	private String description;
	private String author;
	private double price;
	private int pages;
	public BookInput() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookInput(String title, String description, String author, double price, int pages) {
		super();
		this.title = title;
		this.description = description;
		this.author = author;
		this.price = price;
		this.pages = pages;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	@Override
	public String toString() {
		return "BookInput [title=" + title + ", description=" + description + ", author=" + author + ", price=" + price + ", pages="
				+ pages + "]";
	}
}
