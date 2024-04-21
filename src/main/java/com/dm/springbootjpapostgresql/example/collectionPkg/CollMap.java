package com.dm.springbootjpapostgresql.example.collectionPkg;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CollMap {

	public static void main(String[] args) {
	    Map map=new HashMap();  
		System.out.println("------Java Map Example: Non-Generic (Old Style)--------");		
	    
	    //Adding elements to map  
	    map.put(1,"Amit");  
	    map.put(5,"Rahul");  
	    map.put(2,"Jai");  
	    map.put(6,"Amit");  
	    //Traversing Map  
	    Set set=map.entrySet();//Converting to Set so that we can traverse  
	    Iterator itr=set.iterator();  
	    while(itr.hasNext()){  
	        //Converting to Map.Entry so that we can get key and value separately  
	        Map.Entry entry=(Map.Entry)itr.next();  
	        System.out.println(entry.getKey()+" "+entry.getValue());  
	    }  
		System.out.println("------Java Map Example: Generic (New Style)--------");		
		  Map<Integer,String> map2=new HashMap<Integer,String>();  
		  map2.put(100,"Amit");  
		  map2.put(101,"Vijay");  
		  map2.put(102,"Rahul");  
		  //Elements can traverse in any order  
		  for(Map.Entry m:map2.entrySet()){  
		   System.out.println(m.getKey()+" "+m.getValue());  
		  }  		
			System.out.println("------Java Map Example: comparingByKey()--------");		
	    
		  Map<Integer,String> map3=new HashMap<Integer,String>();          
	      map3.put(100,"Amit");    
	      map3.put(101,"Vijay");    
	      map3.put(102,"Rahul");   
	      //Returns a Set view of the mappings contained in this map        
	      map3.entrySet()  
	      //Returns a sequential Stream with this collection as its source  
	      .stream()  
	      //Sorted according to the provided Comparator  
	      .sorted(Map.Entry.comparingByKey())  
	      //Performs an action for each element of this stream  
	      .forEach(System.out::println);  		
	      
			System.out.println("------Java Map Example: comparingByKey() in Descending Order--------");
			Map<Integer,String> map4=new HashMap<Integer,String>();          
		      map4.put(100,"Amit");    
		      map4.put(101,"Vijay");    
		      map4.put(102,"Rahul");    
		      //Returns a Set view of the mappings contained in this map    
		      map4.entrySet()  
		      //Returns a sequential Stream with this collection as its source  
		      .stream()  
		      //Sorted according to the provided Comparator  
		      .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))  
		      //Performs an action for each element of this stream  
		      .forEach(System.out::println); 			

				System.out.println("------Java Map Example: comparingByValue()--------");
				Map<Integer,String> map5=new HashMap<Integer,String>();          
			      map5.put(100,"Amit");    
			      map5.put(101,"Vijay");    
			      map5.put(102,"Rahul");    
			      //Returns a Set view of the mappings contained in this map    
			      map5.entrySet()  
			      //Returns a sequential Stream with this collection as its source  
			      .stream()  
			      //Sorted according to the provided Comparator  
			      .sorted(Map.Entry.comparingByValue())  
			      //Performs an action for each element of this stream  
			      .forEach(System.out::println);  				
		      
					System.out.println("------Java Map Example: comparingByValue() in Descending Order--------");
					Map<Integer,String> map6=new HashMap<Integer,String>();          
				      map6.put(100,"Amit");    
				      map6.put(101,"Vijay");    
				      map6.put(102,"Rahul");    
				     //Returns a Set view of the mappings contained in this map    
				     map6.entrySet()  
				     //Returns a sequential Stream with this collection as its source  
				     .stream()  
				     //Sorted according to the provided Comparator  
				     .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))  
				     //Performs an action for each element of this stream  
				     .forEach(System.out::println);  					
			      
			
	}

}
