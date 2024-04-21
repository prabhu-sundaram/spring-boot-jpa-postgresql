package com.dm.springbootjpapostgresql.example.ComparatorGenericExample;

import java.util.*;
import com.dm.springbootjpapostgresql.example.beans.Student33;

import java.io.*;  
class Simple{  
public static void main(String args[]){  
  
ArrayList<Student33> al=new ArrayList<Student33>();  
al.add(new Student33(101,"Vijay",23));  
al.add(new Student33(106,"Ajay",27));  
al.add(new Student33(105,"Jai",21));  
  
System.out.println("Sorting by Name");  
  
Collections.sort(al,new NameComparator());  
for(Student33 st: al){  
System.out.println(st.getRollno()+" "+st.getName()+" "+st.getAge());  
}  
  
System.out.println("Sorting by age");  
  
Collections.sort(al,new AgeComparator());  
for(Student33 st: al){  
	System.out.println(st.getRollno()+" "+st.getName()+" "+st.getAge());  
}  
}  
}  