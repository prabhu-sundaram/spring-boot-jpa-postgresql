package com.dm.springbootjpapostgresql.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book_details")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private String description;
	private String author;
	private double price;
	private int pages;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int id, String title, String description, String author, double price, int pages) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.author = author;
		this.price = price;
		this.pages = pages;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "Book [id=" + id + ", title=" + title + ", description=" + description + ", author=" + author + ", price=" + price
				+ ", pages=" + pages + "]";
	}
}
