package com.dm.springbootjpapostgresql.example.collectionPkg;

import java.util.EnumMap;
import java.util.Map;

 

public class CollEnumMap {

	// create an enum  
	public enum Days {  
	Monday, Tuesday, Wednesday, Thursday  
	}; 
	
	public static void main(String[] args) {
		System.out.println("------Java EnumMap Example--------");
		   //create and populate enum map  
		   EnumMap<Days, String> map = new EnumMap<Days, String>(Days.class);  
		   map.put(Days.Monday, "1");  
		   map.put(Days.Tuesday, "2");  
		   map.put(Days.Wednesday, "3");  
		   map.put(Days.Thursday, "4");  
		   // print the map  
		   for(Map.Entry m:map.entrySet()){    
		       System.out.println(m.getKey()+" "+m.getValue());    
		      }   		
}
}