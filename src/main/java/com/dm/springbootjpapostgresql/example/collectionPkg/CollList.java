package com.dm.springbootjpapostgresql.example.collectionPkg;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CollList {

	public static void main(String[] args) {
	      System.out.println("---------Java List Example----------");  	   
		 //Creating a List  
		 List<String> list=new ArrayList<String>();  
		 //Adding elements in the List  
		 list.add("Mango");  
		 list.add("Apple");  
		 list.add("Banana");  
		 list.add("Grapes");  
		 //Iterating the List element using for-each loop  
		 for(String fruit:list)  
		  System.out.println(fruit);   
	      
	      System.out.println("-------------------");
	      System.out.println("---------convert Array to List----------");  	   
	    //Creating Array  
	      String[] array={"Java","Python","PHP","C++"};  
	      System.out.println("Printing Array: "+Arrays.toString(array));  
	      //Converting Array to List  
	      List<String> list4=new ArrayList<String>();  
	      for(String lang:array){  
	      list4.add(lang);  
	      }  
	      System.out.println("Printing List: "+list4);  
	      System.out.println("-------------------");
	      
	      System.out.println("--------convert List to Array-----------");
	      List<String> fruitList = new ArrayList<>();    
	      fruitList.add("Mango");    
	      fruitList.add("Banana");    
	      fruitList.add("Apple");    
	      fruitList.add("Strawberry");    
	      //Converting ArrayList to Array  
	      String[] array2 = fruitList.toArray(new String[fruitList.size()]);    
	      System.out.println("Printing Array: "+Arrays.toString(array2));  
	      System.out.println("Printing List: "+fruitList); 
	      System.out.println("-------------------");
	      
	      System.out.println("--------Get and Set Element in List-----------");
	      ArrayList<String> al=new ArrayList<String>();  
	      al.add("Mango");  
	      al.add("Apple");  
	      al.add("Banana");  
	      al.add("Grapes");  
	      for(String fruit:al)    
		        System.out.println(fruit);  	      
	      //accessing the element    
	      System.out.println("Returning element: "+al.get(1));//it will return the 2nd element, because index starts from 0  
	      //changing the element  
	      al.set(1,"Dates");  
	      //Traversing list  
	      for(String fruit:al)    
	        System.out.println(fruit);   
	      
	      System.out.println("-------------------");
	      System.out.println("Sorting list...");
	      //Creating a list of fruits  
	      List<String> list1=new ArrayList<String>();  
	      list1.add("Mango");  
	      list1.add("Apple");  
	      list1.add("Banana");  
	      list1.add("Grapes");  
	      //Sorting the list  
	      Collections.sort(list1);  
	       //Traversing list through the for-each loop  
	      for(String fruit:list1)  
	        System.out.println(fruit);  
	          
	      System.out.println("-------------------");
	      
	     System.out.println("Sorting numbers...");  
	      //Creating a list of numbers  
	      List<Integer> list22=new ArrayList<Integer>();  
	      list22.add(21);  
	      list22.add(11);  
	      list22.add(51);  
	      list22.add(1);  
	      list22.add(2); 
	      //Sorting the list  
	      Collections.sort(list22);  
	       //Traversing list through the for-each loop  
	      for(Integer number:list22)  
	        System.out.println(number);  
	     
	      System.out.println("---------ListIterator Interface----------");
	             
		  List<String> al5=new ArrayList<String>();    
	        al5.add("Amit");    
	        al5.add("Vijay");    
	        al5.add("Kumar");    
	        al5.add(1,"Sachin");    
	        ListIterator<String> itr5=al5.listIterator();    
	        System.out.println("Traversing elements in forward direction");    
	        while(itr5.hasNext()){    
	              
	        System.out.println("index:"+itr5.nextIndex()+" value:"+itr5.next());    
	        }    
	        System.out.println("Traversing elements in backward direction");    
	        while(itr5.hasPrevious()){    
	          
	        System.out.println("index:"+itr5.previousIndex()+" value:"+itr5.previous());    
	        }    
	                    
      	      System.out.println("---------Java ArrayList Serialization and Deserialization----------");
             
             ArrayList<String> al55=new ArrayList<String>();  
             al55.add("Ravi");    
             al55.add("Vijay");    
             al55.add("Ajay");    
               
             try  
             {  
                 //Serialization  
                 FileOutputStream fos=new FileOutputStream("file");  
                 ObjectOutputStream oos=new ObjectOutputStream(fos);  
                 oos.writeObject(al55);  
                 fos.close();  
                 oos.close();  
                 //Deserialization  
                 FileInputStream fis=new FileInputStream("file");  
                 ObjectInputStream ois=new ObjectInputStream(fis);  
               ArrayList  list6=(ArrayList)ois.readObject();  
               System.out.println(list6);    
             }catch(Exception e)  
             {  
                 System.out.println(e);  
             }         
             

     	      
             
	}

}
