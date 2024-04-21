package com.dm.springbootjpapostgresql.example.collectionPkg;

import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class CollTreeMap {

	public static void main(String[] args) {
		System.out.println("------Java TreeMap Example--------");
		
		   TreeMap<Integer,String> map=new TreeMap<Integer,String>();    
		      map.put(100,"Amit");    
		      map.put(102,"Ravi");    
		      map.put(101,"Vijay");    
		      map.put(103,"Rahul");    
		      map.put(104,"Rahul");  
		        
		      for(Map.Entry m:map.entrySet()){    
		       System.out.println(m.getKey()+" "+m.getValue());    
		      }   
				System.out.println("------Java TreeMap Example: remove()--------");
				   TreeMap<Integer,String> map2=new TreeMap<Integer,String>();    
				      map2.put(100,"Amit");    
				      map2.put(102,"Ravi");    
				      map2.put(101,"Vijay");    
				      map2.put(103,"Rahul");    
				      System.out.println("Before invoking remove() method");  
				      for(Map.Entry m:map2.entrySet())  
				      {  
				          System.out.println(m.getKey()+" "+m.getValue());      
				      }  
				      map2.remove(102);      
				      System.out.println("After invoking remove() method");  
				      for(Map.Entry m:map2.entrySet())  
				      {  
				          System.out.println(m.getKey()+" "+m.getValue());      
				      }  				
		      
						System.out.println("------Java TreeMap Example: NavigableMap--------");
						 NavigableMap<Integer,String> map3=new TreeMap<Integer,String>();    
					      map3.put(100,"Amit");    
					      map3.put(102,"Ravi");    
					      map3.put(101,"Vijay");    
					      map3.put(103,"Rahul");    
					      //Maintains descending order  
					      System.out.println("descendingMap: "+map3.descendingMap());  
					      //Returns key-value pairs whose keys are less than or equal to the specified key.  
					      System.out.println("headMap: "+map3.headMap(102,true));  
					      //Returns key-value pairs whose keys are greater than or equal to the specified key.  
					      System.out.println("tailMap: "+map3.tailMap(102,true));  
					      //Returns key-value pairs exists in between the specified key.  
					      System.out.println("subMap: "+map3.subMap(100, false, 102, true));   						

							System.out.println("------Java TreeMap Example: SortedMap--------");
							  SortedMap<Integer,String> map4=new TreeMap<Integer,String>();    
						      map4.put(100,"Amit");    
						      map4.put(102,"Ravi");    
						      map4.put(101,"Vijay");    
						      map4.put(103,"Rahul");    
						      //Returns key-value pairs whose keys are less than the specified key.  
						      System.out.println("headMap: "+map4.headMap(102));  
						      //Returns key-value pairs whose keys are greater than or equal to the specified key.  
						      System.out.println("tailMap: "+map4.tailMap(102));  
						      //Returns key-value pairs exists in between the specified key.  
						      System.out.println("subMap: "+map4.subMap(100, 102));   							

	}

}
