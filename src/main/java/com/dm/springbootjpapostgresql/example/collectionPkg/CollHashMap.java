package com.dm.springbootjpapostgresql.example.collectionPkg;

import java.util.HashMap;
import java.util.Map;

public class CollHashMap {

	public static void main(String[] args) {
		System.out.println("------Java HashMap Example--------");		
		
		   HashMap<Integer,String> map=new HashMap<Integer,String>();//Creating HashMap    
		   map.put(1,"Mango");  //Put elements in Map  
		   map.put(2,"Apple");    
		   map.put(3,"Banana");   
		   map.put(4,"Grapes");   
		       
		   System.out.println("Iterating Hashmap...");  
		   for(Map.Entry m : map.entrySet()){    
		    System.out.println(m.getKey()+" "+m.getValue());    
		   }  
			System.out.println("------No Duplicate Key on HashMap--------");		

		   HashMap<Integer,String> map2=new HashMap<Integer,String>();//Creating HashMap    
		   map2.put(1,"Mango");  //Put elements in Map  
		   map2.put(2,"Apple");    
		   map2.put(3,"Banana");   
		   map2.put(1,"Grapes"); //trying duplicate key  
		       
		   System.out.println("Iterating Hashmap...");  
		   for(Map.Entry m : map2.entrySet()){    
		    System.out.println(m.getKey()+" "+m.getValue());    
		   } 		   
		   
			System.out.println("------Java HashMap example to add() elements--------");		
			  HashMap<Integer,String> hm=new HashMap<Integer,String>();    
			    System.out.println("Initial list of elements: "+hm);  
			      hm.put(100,"Amit");    
			      hm.put(101,"Vijay");    
			      hm.put(102,"Rahul");   
			       
			      System.out.println("After invoking put() method ");  
			      for(Map.Entry m:hm.entrySet()){    
			       System.out.println(m.getKey()+" "+m.getValue());    
			      }  
			        
			      hm.putIfAbsent(103, "Gaurav");  
			      System.out.println("After invoking putIfAbsent() method ");  
			      for(Map.Entry m:hm.entrySet()){    
			           System.out.println(m.getKey()+" "+m.getValue());    
			          }  
			      HashMap<Integer,String> hm2=new HashMap<Integer,String>();  
			      hm2.put(104,"Ravi");  
			      hm2.putAll(hm);  
			      System.out.println("After invoking putAll() method ");  
			      for(Map.Entry m:hm2.entrySet()){    
			           System.out.println(m.getKey()+" "+m.getValue());    
			          }  			
		   
					System.out.println("------Java HashMap example to remove() elements--------");		
				    HashMap<Integer,String> hm4=new HashMap<Integer,String>();          
				    hm4.put(100,"Amit");    
				    hm4.put(101,"Vijay");    
				    hm4.put(102,"Rahul");  
				    hm4.put(103, "Gaurav");  
				    System.out.println("Initial list of elements: "+hm4);  
				    //key-based removal  
				    hm4.remove(100);  
				    System.out.println("Updated list of elements: "+hm4);  
				    //value-based removal  
				    hm4.remove(101);  
				    System.out.println("Updated list of elements: "+hm4);  
				    //key-value pair based removal  
				    hm4.remove(102, "Rahul");  
				    System.out.println("Updated list of elements: "+hm4);  
				    
					System.out.println("------Java HashMap example to replace() elements--------");		
					   HashMap<Integer,String> hm5=new HashMap<Integer,String>();    
					   	  hm5.put(100,"Amit");    
					      hm5.put(101,"Vijay");    
					      hm5.put(102,"Rahul");   
					      System.out.println("Initial list of elements:");  
					     for(Map.Entry m:hm5.entrySet())  
					     {  
					        System.out.println(m.getKey()+" "+m.getValue());   
					     }  
					     System.out.println("Updated list of elements:");  
					     hm5.replace(102, "Gaurav");  
					     for(Map.Entry m:hm5.entrySet())  
					     {  
					        System.out.println(m.getKey()+" "+m.getValue());   
					     }  
					     System.out.println("Updated list of elements:");  
					     hm5.replace(101, "Vijay", "Ravi");  
					     for(Map.Entry m:hm5.entrySet())  
					     {  
					        System.out.println(m.getKey()+" "+m.getValue());   
					     }   
					     System.out.println("Updated list of elements:");  
					     hm5.replaceAll((k,v) -> "Ajay");  
					     for(Map.Entry m:hm5.entrySet())  
					     {  
					        System.out.println(m.getKey()+" "+m.getValue());   
					     }  					
				    
	}

}
