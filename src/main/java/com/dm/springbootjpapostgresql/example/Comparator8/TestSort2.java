package com.dm.springbootjpapostgresql.example.Comparator8;

import java.util.*;

import com.dm.springbootjpapostgresql.example.beans.Student33;    
public class TestSort2{    
public static void main(String args[]){    
ArrayList<Student33> al=new ArrayList<Student33>();    
al.add(new Student33(101,"Vijay",23));    
al.add(new Student33(106,"Ajay",27));    
al.add(new Student33(105,null,21));    

Comparator<Student33> cm1=Comparator.comparing(Student33::getName,Comparator.nullsFirst(String::compareTo));  
 Collections.sort(al,cm1);  
 System.out.println("Considers null to be less than non-null");  
 for(Student33 st: al){  
	 System.out.println(st.getRollno()+" "+st.getName()+" "+st.getAge());   
    }  
 
 Comparator<Student33> cm2=Comparator.comparing(Student33::getName,Comparator.nullsLast(String::compareTo));  
 Collections.sort(al,cm2);  
 System.out.println("Considers null to be greater than non-null");  
 for(Student33 st: al){  
	 System.out.println(st.getRollno()+" "+st.getName()+" "+st.getAge());  
    }  
}    
}     