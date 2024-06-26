package com.dm.springbootjpapostgresql.example.beans;

import java.util.*;

public class Book {
	private int id;
	private String name, author, publisher;
	private int quantity;

	public Book(int id, String name, String author, String publisher, int quantity) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
//for TreeSet,PriorityQueue
/*
 * class Book implements Comparable<Book>{ int id; String name,author,publisher;
 * int quantity; public Book(int id, String name, String author, String
 * publisher, int quantity) { this.id = id; this.name = name; this.author =
 * author; this.publisher = publisher; this.quantity = quantity; }
 * 
 * public int compareTo(Book b) { if(id>b.id){ return 1; }else if(id<b.id){
 * return -1; }else{ return 0; } }
 * 
 * }
 */
