package com.dm.springbootjpapostgresql.example.collectionPkg;

import java.util.Iterator;
import java.util.LinkedList;

public class CollLinkedList {

	public static void main(String[] args) {
		System.out.println("-------LinkedHashSet--------");
		
		  LinkedList<String> al=new LinkedList<String>();  
		  al.add("Ravi");  
		  al.add("Vijay");  
		  al.add("Ravi");  
		  al.add("Ajay");  
		  
		  Iterator<String> itr=al.iterator();  
		  while(itr.hasNext()){  
		   System.out.println(itr.next());  
		  }  
			System.out.println("---------------");
			System.out.println("-------Java LinkedList example to add elements--------");
			 LinkedList<String> ll=new LinkedList<String>();  
	           System.out.println("Initial list of elements: "+ll);  
	           ll.add("Ravi");  
	           ll.add("Vijay");  
	           ll.add("Ajay");  
	           System.out.println("After invoking add(E e) method: "+ll);  
	           //Adding an element at the specific position  
	           ll.add(1, "Gaurav");  
	           System.out.println("After invoking add(int index, E element) method: "+ll);  
	           LinkedList<String> ll2=new LinkedList<String>();  
	           ll2.add("Sonoo");  
	           ll2.add("Hanumat");  
	           //Adding second list elements to the first list  
	           ll.addAll(ll2);  
	           System.out.println("After invoking addAll(Collection<? extends E> c) method: "+ll);  
	           LinkedList<String> ll3=new LinkedList<String>();  
	           ll3.add("John");  
	           ll3.add("Rahul");  
	           //Adding second list elements to the first list at specific position  
	           ll.addAll(1, ll3);  
	           System.out.println("After invoking addAll(int index, Collection<? extends E> c) method: "+ll);  
	           //Adding an element at the first position  
	           ll.addFirst("Lokesh");  
	           System.out.println("After invoking addFirst(E e) method: "+ll);  
	           //Adding an element at the last position  
	           ll.addLast("Harsh");  
	           System.out.println("After invoking addLast(E e) method: "+ll);  		
				System.out.println("---------------");
				System.out.println("-------Java LinkedList example to remove elements--------");
		         LinkedList<String> ll4=new LinkedList<String>();  
		         ll4.add("Ravi");  
		         ll4.add("Vijay");  
		         ll4.add("Ajay");  
		         ll4.add("Anuj");  
		         ll4.add("Gaurav");  
		         ll4.add("Harsh");  
		         ll4.add("Virat");  
		         ll4.add("Gaurav");  
		         ll4.add("Harsh");  
		         ll4.add("Amit");  
		           System.out.println("Initial list of elements: "+ll4);  
		         //Removing specific element from arraylist  
		           ll4.remove("Vijay");  
		              System.out.println("After invoking remove(object) method: "+ll4);   
		         //Removing element on the basis of specific position  
		              ll4.remove(0);  
		              System.out.println("After invoking remove(index) method: "+ll4);   
		              LinkedList<String> ll22=new LinkedList<String>();  
		              ll22.add("Ravi");  
		              ll22.add("Hanumat");  
		         // Adding new elements to arraylist  
		              ll4.addAll(ll22);  
		              System.out.println("Updated list : "+ll4);   
		         //Removing all the new elements from arraylist  
		              ll4.removeAll(ll22);  
		              System.out.println("After invoking removeAll() method: "+ll4);   
		         //Removing first element from the list  
		              ll4.removeFirst();  
		              System.out.println("After invoking removeFirst() method: "+ll4);  
		          //Removing first element from the list  
		              ll4.removeLast();  
		              System.out.println("After invoking removeLast() method: "+ll4);  
		          //Removing first occurrence of element from the list  
		              ll4.removeFirstOccurrence("Gaurav");  
		              System.out.println("After invoking removeFirstOccurrence() method: "+ll4);  
		          //Removing last occurrence of element from the list  
		              ll4.removeLastOccurrence("Harsh");  
		              System.out.println("After invoking removeLastOccurrence() method: "+ll4);  
		  
		              //Removing all the elements available in the list       
		              ll4.clear();  
		              System.out.println("After invoking clear() method: "+ll4);   				
						System.out.println("---------------");
						
						System.out.println("-------Java LinkedList Example to reverse a list of elements--------");				
						  LinkedList<String> ll5=new LinkedList<String>();  
				           ll5.add("Ravi");  
				           ll5.add("Vijay");  
				           ll5.add("Ajay");  
				           //Traversing the list of elements in reverse order  
				           Iterator i=ll5.descendingIterator();  
				           while(i.hasNext())  
				           {  
				               System.out.println(i.next());  
				           }  	           
		  
	}

}
