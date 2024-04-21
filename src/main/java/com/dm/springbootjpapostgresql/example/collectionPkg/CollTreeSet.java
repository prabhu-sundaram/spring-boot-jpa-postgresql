package com.dm.springbootjpapostgresql.example.collectionPkg;

import java.util.Iterator;
import java.util.TreeSet;

public class CollTreeSet {

	public static void main(String[] args) {
		System.out.println("------Java TreeSet Example 1--------");		
		  //Creating and adding elements  
		  TreeSet<String> al=new TreeSet<String>();  
		  al.add("Ravi");  
		  al.add("Vijay");  
		  al.add("Ravi");  
		  al.add("Ajay");  
		  //Traversing elements  
		  Iterator<String> itr=al.iterator();  
		  while(itr.hasNext()){  
		   System.out.println(itr.next());  
		  } 
			System.out.println("------Java TreeSet Example 2  traversing elements in descending order--------");		
			 TreeSet<String> set=new TreeSet<String>();  
	         set.add("Ravi");  
	         set.add("Vijay");  
	         set.add("Ajay");  
	         System.out.println("Traversing element through Iterator in descending order");  
	         Iterator i=set.descendingIterator();  
	         while(i.hasNext())  
	         {  
	             System.out.println(i.next());  
	         } 			
				System.out.println("------Java TreeSet Example 3 retrieve and remove the highest and lowest Value--------");		
				 TreeSet<Integer> set2=new TreeSet<Integer>();  
		         set2.add(24);  
		         set2.add(66);  
		         set2.add(12);  
		         set2.add(15);  
		         System.out.println("Highest Value: "+set2.pollFirst());  
		         System.out.println("Lowest Value: "+set2.pollLast());  
		         
					System.out.println("------Java TreeSet Example 4 NavigableSet operations--------");		
					  TreeSet<String> set3=new TreeSet<String>();  
				         set3.add("A");  
				         set3.add("B");  
				         set3.add("C");  
				         set3.add("D");  
				         set3.add("E");  
				         System.out.println("Initial Set: "+set3);  				           
				         System.out.println("Reverse Set: "+set3.descendingSet());  				           
				         System.out.println("Head Set: "+set3.headSet("C", true));  				          
				         System.out.println("SubSet: "+set3.subSet("A", false, "E", true));  				           
				         System.out.println("TailSet: "+set3.tailSet("C", false));  	
				         
							System.out.println("------Java TreeSet Example 4 SortedSetSet operations--------");		
							 TreeSet<String> set4=new TreeSet<String>();  
					         set4.add("A");  
					         set4.add("B");  
					         set4.add("C");  
					         set4.add("D");  
					         set4.add("E");  
					           
					         System.out.println("Intial Set: "+set4);  					           
					         System.out.println("Head Set: "+set4.headSet("C"));  					          
					         System.out.println("SubSet: "+set4.subSet("A", "E"));  					           
					         System.out.println("TailSet: "+set4.tailSet("C"));  							
				         
		         
		  
	}

}
