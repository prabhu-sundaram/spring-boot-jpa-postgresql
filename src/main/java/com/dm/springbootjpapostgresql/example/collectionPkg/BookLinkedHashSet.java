package com.dm.springbootjpapostgresql.example.collectionPkg;

import java.util.LinkedHashSet;

import com.dm.springbootjpapostgresql.example.beans.Book;

public class BookLinkedHashSet {

	public static void main(String[] args) {
	    LinkedHashSet<Book> hs=new LinkedHashSet<Book>();  
	    //Creating Books  
	    Book b1=new Book(101,"Let us C","Yashwant Kanetkar","BPB",8);  
	    Book b2=new Book(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);  
	    Book b3=new Book(103,"Operating System","Galvin","Wiley",6);  
	    Book b4=new Book(103,"Operating System","Galvin","Wiley",6);  
	    //Adding Books to hash table  
	    hs.add(b1);  
	    hs.add(b2);  
	    hs.add(b3);  
	    hs.add(b4);
	    //Traversing hash table  
	    for(Book b:hs){  
	    	System.out.println(b.getId()+" "+b.getName()+" "+b.getAuthor()+" "+b.getPublisher()+" "+b.getQuantity());
	    }  

	}

}
