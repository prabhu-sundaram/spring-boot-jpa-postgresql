package com.dm.springbootjpapostgresql.example.collectionPkg;

import java.util.ArrayList;
import java.util.Collections;

import com.dm.springbootjpapostgresql.example.beans.Student3;

public class Coll4SortReverse {

	public static void main(String[] args) {
		ArrayList<Student3> al=new ArrayList<Student3>();    
		al.add(new Student3(101,"Vijay",23));    
		al.add(new Student3(106,"Ajay",27));    
		al.add(new Student3(105,"Jai",21));    
		    
		//Collections.sort(al);    
		for(Student3 st:al){    
		System.out.println(st.getRollno()+" "+st.getName()+" "+st.getAge());    
		}    

	}

}
