package com.dm.springbootjpapostgresql.example.collectionPkg;

import java.util.Hashtable;
import java.util.Map;

public class CollHashtable {

	public static void main(String[] args) {
		System.out.println("------Java Hashtable Example--------");		
		  Hashtable<Integer,String> hm=new Hashtable<Integer,String>();  
		  
		  hm.put(100,"Amit");  
		  hm.put(102,"Ravi");  
		  hm.put(101,"Vijay");  
		  hm.put(103,"Rahul");  
		  
		  for(Map.Entry m:hm.entrySet()){  
		   System.out.println(m.getKey()+" "+m.getValue());  
		  }  		

			System.out.println("------Java Hashtable Example: remove()--------");	
			  Hashtable<Integer,String> map=new Hashtable<Integer,String>();        
			     map.put(100,"Amit");    
			     map.put(102,"Ravi");   
			     map.put(101,"Vijay");    
			     map.put(103,"Rahul");    
			     System.out.println("Before remove: "+ map);    
			       // Remove value for key 102  
			       map.remove(102);  
			       System.out.println("After remove: "+ map);  			
		  
					System.out.println("------Java Hashtable Example: getOrDefault()--------");	
				    Hashtable<Integer,String> map2=new Hashtable<Integer,String>();          
				     map2.put(100,"Amit");    
				     map2.put(102,"Ravi");   
				     map2.put(101,"Vijay");    
				     map2.put(103,"Rahul");    
				     //Here, we specify the if and else statement as arguments of the method  
				     System.out.println(map2.getOrDefault(101, "Not Found"));  
				     System.out.println(map2.getOrDefault(105, "Not Found"));  					
			       
						System.out.println("------Java Hashtable Example: putIfAbsent()--------");	
					    Hashtable<Integer,String> map3=new Hashtable<Integer,String>();          
					     map3.put(100,"Amit");    
					     map3.put(102,"Ravi");   
					     map3.put(101,"Vijay");    
					     map3.put(103,"Rahul");    
					     System.out.println("Initial Map: "+map3);  
					     //Inserts, as the specified pair is unique  
					     map3.putIfAbsent(104,"Gaurav");  
					     System.out.println("Updated Map: "+map3);  
					     //Returns the current value, as the specified pair already exist  
					     map3.putIfAbsent(101,"Vijay");  
					     System.out.println("Updated Map: "+map3);  						
				     
	}

}
