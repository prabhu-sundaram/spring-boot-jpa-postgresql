package com.dm.springbootjpapostgresql.example.stringPkg;

public class StringBuilderExample {

	public static void main(String[] args) {
		StringBuilder sb=new StringBuilder("Hello ");  
		sb.append("Java");//now original string is changed  
		System.out.println(sb);//prints Hello Java  

		StringBuilder sb2=new StringBuilder("Hello ");  
		sb2.insert(1,"Java");//now original string is changed  
		System.out.println(sb2);//prints HJavaello 
		
		StringBuilder sb3=new StringBuilder("Hello");  
		sb3.replace(1,3,"Java");  
		System.out.println(sb3);//prints HJavalo
		
		StringBuilder sb4=new StringBuilder("Hello");  
		sb4.delete(1,3);  
		System.out.println(sb4);//prints Hlo  		
		
		StringBuilder sb5=new StringBuilder("Hello");  
		sb5.reverse();  
		System.out.println(sb5);//prints olleH  		
	      System.out.println("-------------------");
		
		StringBuilder sb6=new StringBuilder();  
		System.out.println(sb6.capacity());//default 16  
		sb6.append("Hello");  
		System.out.println(sb6.capacity());//now 16  
		sb6.append("java is my favourite language");  
		System.out.println(sb6.capacity());//now (16*2)+2=34 i.e (oldcapacity*2)+2  
	      System.out.println("-------------------");
		
	      StringBuilder sb7=new StringBuilder();  
	      System.out.println(sb7.capacity());//default 16  
	      sb7.append("Hello");  
	      System.out.println(sb7.capacity());//now 16  
	      sb7.append("java is my favourite language");  
	      System.out.println(sb7.capacity());//now (16*2)+2=34 i.e (oldcapacity*2)+2  
	      sb7.ensureCapacity(10);//now no change  
	      System.out.println(sb7.capacity());//now 34  
	      sb7.ensureCapacity(50);//now (34*2)+2  
	      System.out.println(sb7.capacity());//now 70  
	      
	}

}
