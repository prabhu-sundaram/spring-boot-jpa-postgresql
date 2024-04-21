package com.dm.springbootjpapostgresql.example.Comparator8;

import java.util.*;

import com.dm.springbootjpapostgresql.example.beans.Student33;    
public class TestSort1{    
public static void main(String args[]){  

ArrayList<Student33> al=new ArrayList<Student33>();    
al.add(new Student33(101,"Vijay",23));    
al.add(new Student33(106,"Ajay",27));    
al.add(new Student33(105,"Jai",21));  

//Sorting elements on the basis of name  
Comparator<Student33> cm1=Comparator.comparing(Student33::getName);  
 Collections.sort(al,cm1);  
 System.out.println("Sorting by Name");  
 for(Student33 st: al){  
   System.out.println(st.getRollno()+" "+st.getName()+" "+st.getAge());  
   }  
 //Sorting elements on the basis of age  
  Comparator<Student33> cm2=Comparator.comparing(Student33::getAge);  
Collections.sort(al,cm2);  
 System.out.println("Sorting by Age");  
 for(Student33 st: al){  
	 System.out.println(st.getRollno()+" "+st.getName()+" "+st.getAge());   
   }    
}    
}    