package com.dm.springbootjpapostgresql.example.collectionPkg;

import java.util.EnumMap;
import java.util.Map;

import com.dm.springbootjpapostgresql.example.beans.Book;

public class BookEnumMap {
		// Creating enum  
	    public enum Key{  
	           One, Two, Three , Four, Five
	           };  
	public static void main(String[] args) {    
	    EnumMap<Key, Book> map = new EnumMap<Key, Book>(Key.class);  
	    // Creating Books    
	    Book b1=new Book(101,"Let us C","Yashwant Kanetkar","BPB",8);    
	    Book b2=new Book(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);    
	    Book b3=new Book(103,"Operating System","Galvin","Wiley",6);    
	    Book b4=new Book(103,"Operating System","Galvin","Wiley",6);    
	    // Adding Books to Map   
	       map.put(Key.One, b1);  
	       map.put(Key.Two, b2);  
	       map.put(Key.Three, b3);  
	       map.put(Key.Three, b3);  //duplicate is removed based on key
	       map.put(Key.Four, b4);  
	       map.put(Key.Five, b1);
	    // Traversing EnumMap  
	       for(Map.Entry<Key, Book> entry:map.entrySet()){      
	            Book b=entry.getValue();    
	            System.out.println(b.getId()+" "+b.getName()+" "+b.getAuthor()+" "+b.getPublisher()+" "+b.getQuantity());    
	        }  

	}

}
