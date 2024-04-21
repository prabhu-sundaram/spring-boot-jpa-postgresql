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

public class CollArrayList {

	public static void main(String[] args) {
		  ArrayList<String> list=new ArrayList<String>();//Creating arraylist    
	      list.add("Mango");//Adding object in arraylist    
	      list.add("Apple");    
	      list.add("Banana");    
	      list.add("Grapes");    
	      //Printing the arraylist object   
	      System.out.println(list);  
	      System.out.println("-------------------");
	      
	      System.out.println("--------Iterating ArrayList using Iterator-----------");	      
	      ArrayList<String> list2=new ArrayList<String>();//Creating arraylist  
	      list2.add("Mango");//Adding object in arraylist    
	      list2.add("Apple");    
	      list2.add("Banana");    
	      list2.add("Grapes");    
	      //Traversing list through Iterator  
	      Iterator itr=list.iterator();//getting the Iterator  
	      while(itr.hasNext()){//check if iterator has the elements  
	       System.out.println(itr.next());//printing the element and move to next  
	      }
	      System.out.println("-------------------");
	      
	      System.out.println("--------Iterating ArrayList using For-each loop-----------");
	      
	      //Traversing list through for-each loop  
	      for(String fruit:list)    
	        System.out.println(fruit);    
	      
	      System.out.println("-------------------");

	      System.out.println("--------Get and Set ArrayList-----------");
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
	      System.out.println("---------Traversing----------");
	      
	      ArrayList<String> list3=new ArrayList<String>();//Creating arraylist  
          list3.add("Ravi");//Adding object in arraylist  
          list3.add("Vijay");  
          list3.add("Ravi");  
          list3.add("Ajay");  
           
          System.out.println("Traversing list through List Iterator:");  
          //Here, element iterates in reverse order  
             ListIterator<String> list5=list3.listIterator(list3.size());  
             while(list5.hasPrevious())  
             {  
                 String str=list5.previous();  
                 System.out.println(str);  
             }  
       System.out.println("Traversing list through for loop:");  
          for(int i=0;i<list3.size();i++)  
          {  
           System.out.println(list3.get(i));     
          }  
             
       System.out.println("Traversing list through forEach() method:");  
       //The forEach() method is a new feature, introduced in Java 8.  
		
		  list3.forEach(a->{ //Here, we are using lambda expression
		  System.out.println(a); });
		  
               
           System.out.println("Traversing list through forEachRemaining() method:");  
		
		  Iterator<String> itr3=list3.iterator(); 
		  itr3.forEachRemaining(a-> //Here, we are using lambda expression 
		  { System.out.println(a); });
		  	      
                   
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
             
     	     System.out.println("---------Java ArrayList example to add elements----------");
     	     ArrayList<String> al6=new ArrayList<String>();  
             System.out.println("Initial list of elements: "+al6);  
             //Adding elements to the end of the list  
             al6.add("Ravi");  
             al6.add("Vijay");  
             al6.add("Ajay");  
             System.out.println("After invoking add(E e) method: "+al6);  
             //Adding an element at the specific position  
             al6.add(1, "Gaurav");  
             System.out.println("After invoking add(int index, E element) method: "+al6);  
             ArrayList<String> al62=new ArrayList<String>();  
             al62.add("Sonoo");  
             al62.add("Hanumat");  
             //Adding second list elements to the first list  
             al6.addAll(al62);  
             System.out.println("After invoking addAll(Collection<? extends E> c) method: "+al6);  
             ArrayList<String> al63=new ArrayList<String>();  
             al63.add("John");  
             al63.add("Rahul");  
             //Adding second list elements to the first list at specific position  
             al6.addAll(1, al63);  
             System.out.println("After invoking addAll(int index, Collection<? extends E> c) method: "+al6);       	      
             
             System.out.println("---------Java ArrayList example to remove elements----------");             
             ArrayList<String> al7=new ArrayList<String>();  
             al7.add("Ravi");    
             al7.add("Vijay");    
             al7.add("Ajay");   
             al7.add("Anuj");  
             al7.add("Gaurav");  
             System.out.println("An initial list of elements: "+al7);   
             //Removing specific element from arraylist  
             al7.remove("Vijay");  
             System.out.println("After invoking remove(object) method: "+al7);   
             //Removing element on the basis of specific position  
             al7.remove(0);  
             System.out.println("After invoking remove(index) method: "+al7);   
               
             //Creating another arraylist  
             ArrayList<String> al72=new ArrayList<String>();    
             al72.add("Ravi");    
             al72.add("Hanumat");    
             //Adding new elements to arraylist  
             al7.addAll(al72);  
             System.out.println("Updated list : "+al7);   
             //Removing all the new elements from arraylist  
             al7.removeAll(al72);  
             System.out.println("After invoking removeAll() method: "+al7);   
             //Removing elements on the basis of specified condition  
             al7.removeIf(str -> str.contains("Ajay"));   //Here, we are using Lambda expression   
             System.out.println("After invoking removeIf() method: "+al7);  
             //Removing all the elements available in the list  
             al7.clear();  
             System.out.println("After invoking clear() method: "+al7);       
             
             System.out.println("---------Java ArrayList example of retainAll() method----------");    
             ArrayList<String> al8=new ArrayList<String>();  
             al8.add("Ravi");  
             al8.add("Vijay");  
             al8.add("Ajay");  
             ArrayList<String> al82=new ArrayList<String>();  
             al82.add("Ravi");  
             al82.add("Hanumat");  
             al8.retainAll(al82);  
             System.out.println("iterating the elements after retaining the elements of al82");  
             Iterator itr8=al8.iterator();  
             while(itr8.hasNext()){  
              System.out.println(itr8.next());  
             }               

             System.out.println("---------Java ArrayList example of isEmpty() method----------");
             ArrayList<String> al9=new ArrayList<String>();  
             System.out.println("Is ArrayList Empty: "+al9.isEmpty());  
             al9.add("Ravi");    
             al9.add("Vijay");    
             al9.add("Ajay");    
             System.out.println("After Insertion");  
             System.out.println("Is ArrayList Empty: "+al9.isEmpty());                
             
	}

}
