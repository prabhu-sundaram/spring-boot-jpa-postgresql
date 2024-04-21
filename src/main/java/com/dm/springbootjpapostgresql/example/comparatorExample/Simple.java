package com.dm.springbootjpapostgresql.example.comparatorExample;
import java.util.*;  
import java.io.*; 
import com.dm.springbootjpapostgresql.example.beans.Student33;

public class Simple {

	public static void main(String[] args) {
		  
		ArrayList al=new ArrayList();  
		al.add(new Student33(101,"Vijay",23));  
		al.add(new Student33(106,"Ajay",27));  
		al.add(new Student33(105,"Jai",21));  
		  
		System.out.println("Sorting by Name");  
		  
		Collections.sort(al,new NameComparator());  
		Iterator itr=al.iterator();  
		while(itr.hasNext()){  
			Student33 st=(Student33)itr.next();  
		System.out.println(st.getRollno()+" "+st.getName()+" "+st.getAge());  
		}  
		  
		System.out.println("Sorting by age");  
		  
		Collections.sort(al,new AgeComparator());  
		Iterator itr2=al.iterator();  
		while(itr2.hasNext()){  
			Student33 st=(Student33)itr2.next();  
		System.out.println(st.getRollno()+" "+st.getName()+" "+st.getAge());  
		}  
	}

}
