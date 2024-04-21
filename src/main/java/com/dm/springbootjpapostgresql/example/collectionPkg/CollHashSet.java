package com.dm.springbootjpapostgresql.example.collectionPkg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class CollHashSet {

	public static void main(String[] args) {
		System.out.println("-------Java HashSet Example--------");		
		  //Creating HashSet and adding elements  
	    HashSet<String> set=new HashSet();  
	           set.add("One");    
	           set.add("Two");    
	           set.add("Three");   
	           set.add("Four");  
	           set.add("Five");  
	           Iterator<String> i=set.iterator();  
	           while(i.hasNext())  
	           {  
	           System.out.println(i.next());  
	           }  
	   		System.out.println("-------Java HashSet example ignoring duplicate elements--------");
	   	  //Creating HashSet and adding elements  
	   	  HashSet<String> set2=new HashSet<String>();  
	   	  set2.add("Ravi");  
	   	  set2.add("Vijay");  
	   	  set2.add("Ravi");  
	   	  set2.add("Ajay");  
	   	  //Traversing elements  
	   	  Iterator<String> itr=set2.iterator();  
	   	  while(itr.hasNext()){  
	   	   System.out.println(itr.next());  
	   	  } 	   		
	   		System.out.println("-------Java HashSet example to remove elements--------");
	   	  HashSet<String> set3=new HashSet<String>();  
          set3.add("Ravi");  
          set3.add("Vijay");  
          set3.add("Arun");  
          set3.add("Sumit");  
          System.out.println("An initial list of elements: "+set3);  
          //Removing specific element from HashSet  
          set3.remove("Ravi");  
          System.out.println("After invoking remove(object) method: "+set3);  
          HashSet<String> set4=new HashSet<String>();  
          set4.add("Ajay");  
          set4.add("Gaurav");  
          set3.addAll(set4);  
          System.out.println("Updated List: "+set3);  
          //Removing all the new elements from HashSet  
          set3.removeAll(set4);  
          System.out.println("After invoking removeAll() method: "+set3);  
          //Removing elements on the basis of specified condition  
          set3.removeIf(str3->str3.contains("Vijay"));    
          System.out.println("After invoking removeIf() method: "+set3);  
          //Removing all the elements available in the set  
          set3.clear();  
          System.out.println("After invoking clear() method: "+set3); 
	   		System.out.println("-------Java HashSet from another Collection--------");
	   	   ArrayList<String> list=new ArrayList<String>();  
           list.add("Ravi");  
           list.add("Vijay");  
           list.add("Ajay");  
             
           HashSet<String> set5=new HashSet(list);  
           set5.add("Gaurav");  
           Iterator<String> i2=set5.iterator();  
           while(i2.hasNext())  
           {  
           System.out.println(i2.next());  
           }  	   		
	   		
	}

}
