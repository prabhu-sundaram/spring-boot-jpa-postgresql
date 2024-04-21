package com.dm.springbootjpapostgresql.example.collectionPkg;

import java.util.ArrayList;
import java.util.Iterator;

import com.dm.springbootjpapostgresql.example.beans.Student3;

public class StudentArrayList {

	public static void main(String[] args) {
 	      System.out.println("---------User-defined class objects in Java ArrayList----------");
          
          //Creating user-defined class objects  
          Student3 s1=new Student3(101,"Sonoo",23);  
          Student3 s2=new Student3(102,"Ravi",21);  
          Student3 s3=new Student3(103,"Hanumat",25);  
          //creating arraylist  
          ArrayList<Student3> al2=new ArrayList<Student3>();  
          al2.add(s1);//adding Student class object  
          al2.add(s2);  
          al2.add(s3);  
          //Getting Iterator  
          Iterator itr4=al2.iterator();  
          //traversing elements of ArrayList object  
          while(itr4.hasNext()){  
            Student3 st=(Student3)itr4.next();  
            System.out.println(st.getRollno()+" "+st.getName()+" "+st.getAge());
          }        

	}

}
