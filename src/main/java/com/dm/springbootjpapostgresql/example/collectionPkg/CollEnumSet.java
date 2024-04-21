package com.dm.springbootjpapostgresql.example.collectionPkg;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;



public class CollEnumSet {

	enum days {  
		  SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY  
		}  
	
	public static void main(String[] args) {
		System.out.println("------Java EnumSet Example--------");	
		
	    Set<days> set = EnumSet.of(days.TUESDAY, days.WEDNESDAY);  
	    // Traversing elements  
	    Iterator<days> iter = set.iterator();  
	    while (iter.hasNext())  
	      System.out.println(iter.next());  
	    
		System.out.println("------Java EnumSet Example: allOf() and noneOf()--------");	
	    Set<days> set1 = EnumSet.allOf(days.class);  
	      System.out.println("Week Days:"+set1);  
	      Set<days> set2 = EnumSet.noneOf(days.class);  
	      System.out.println("Week Days:"+set2);     		
	    
	  }
	}

