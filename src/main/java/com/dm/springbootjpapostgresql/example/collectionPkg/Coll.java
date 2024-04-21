package com.dm.springbootjpapostgresql.example.collectionPkg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Coll {

	public static void main(String[] args) {
		System.out.println("------Java Collections Example--------");
		
        List<String> list = new ArrayList<String>();  
        list.add("C");  
        list.add("Core Java");  
        list.add("Advance Java");  
        System.out.println("Initial collection value:"+list);  
        Collections.addAll(list, "Servlet","JSP");  
        System.out.println("After adding elements collection value:"+list);  
        String[] strArr = {"C#", ".Net"};  
        Collections.addAll(list, strArr);  
        System.out.println("After adding array collection value:"+list);  
        
		System.out.println("------Java Collections Example: max()--------");
	       List<Integer> list2 = new ArrayList<Integer>();  
	        list2.add(46);  
	        list2.add(67);  
	        list2.add(24);  
	        list2.add(16);  
	        list2.add(8);  
	        list2.add(12);  
	        System.out.println("Value of maximum element from the collection: "+Collections.max(list2));  		
        
			System.out.println("------Java Collections Example: min()--------");
	        List<Integer> list3 = new ArrayList<Integer>();  
	        list3.add(46);  
	        list3.add(67);  
	        list3.add(24);  
	        list3.add(16);  
	        list3.add(8);  
	        list3.add(12);  
	        System.out.println("Value of minimum element from the collection: "+Collections.min(list3));  			
	        
			System.out.println("------Example to sort string objects--------");
			ArrayList<String> al=new ArrayList<String>();  
			al.add("Viru");  
			al.add("Saurav");  
			al.add("Mukesh");  
			al.add("Tahir");  
			  
			Collections.sort(al);  
			Iterator itr=al.iterator();  
			while(itr.hasNext()){  
			System.out.println(itr.next());  
			 }  			

			System.out.println("------Example to sort string objects in reverse order--------");
			ArrayList<String> al2=new ArrayList<String>();  
	        al2.add("Viru");    
	        al2.add("Saurav");    
	        al2.add("Mukesh");    
	        al2.add("Tahir");   
	          
	        Collections.sort(al2,Collections.reverseOrder());  
	        Iterator i=al.iterator();  
	        while(i.hasNext())  
	        {  
	            System.out.println(i.next());  
	        }  		
	        
			System.out.println("------Example to sort Wrapper class objects--------");
			ArrayList al3=new ArrayList();  
			al3.add(Integer.valueOf(201));  
			al3.add(Integer.valueOf(101));  
			al3.add(230);//internally will be converted into objects as Integer.valueOf(230)  
			  
			Collections.sort(al3);  
			  
			Iterator itr2=al3.iterator();  
			while(itr2.hasNext()){  
			System.out.println(itr2.next());  
			 }  			
			System.out.println("------Example to sort user-defined class objects--------");
	        
	}

}
