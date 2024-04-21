package com.dm.springbootjpapostgresql.example.collectionPkg;

import java.util.ArrayDeque;
import java.util.Deque;

public class CollArrayDeque {

	public static void main(String[] args) {
		System.out.println("------Java ArrayDeque Example--------");		
		
		 //Creating Deque and adding elements  
		   Deque<String> deque = new ArrayDeque<String>();  
		   deque.add("Ravi");    
		   deque.add("Vijay");     
		   deque.add("Ajay");    
		   //Traversing elements  
		   for (String str : deque) {  
		   System.out.println(str);  
		   }  
			System.out.println("------Java ArrayDeque Example: offerFirst() and pollLast()--------");		
		    Deque<String> deque2=new ArrayDeque<String>();  
		    deque2.offer("arvind");  
		    deque2.offer("vimal");  
		    deque2.add("mukul");  
		    deque2.offerFirst("jai");  
		    System.out.println("After offerFirst Traversal...");  
		    for(String s:deque2){  
		        System.out.println(s);  
		    }  
		    //deque.poll();  
		    //deque.pollFirst();//it is same as poll()  
		    deque2.pollLast();  
		    System.out.println("After pollLast() Traversal...");  
		    for(String s:deque2){  
		        System.out.println(s);  
		    }  		   
	}

}
