package com.dm.springbootjpapostgresql.example.stringPkg;

public class StringExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="hello";  
		System.out.println(s.substring(0,2));//he  
		
		   String s2="SachinTendulkar";  
		   System.out.println(s2.substring(6));//Tendulkar  
		   System.out.println(s2.substring(0,6));//Sachin  		
		      System.out.println("-------------------");
		   
		   String s3="Sachin";  
		   System.out.println(s3.toUpperCase());//SACHIN  
		   System.out.println(s3.toLowerCase());//sachin  
		   System.out.println(s3);//Sachin(no change in original)  		
		   
		      System.out.println("-------------------");
		      String s4="  Sachin  ";  
		      System.out.println(s4);//  Sachin    
		      System.out.println(s4.trim());//Sachin  
		      System.out.println("-------------------");
		      
		      String s5="Sachin";  
		      System.out.println(s5.startsWith("Sa"));//true  
		      System.out.println(s5.endsWith("n"));//true  		      
		      System.out.println("-------------------");
		      String s6="Sachin";  
		      System.out.println(s6.charAt(0));//S  
		      System.out.println(s6.charAt(3));//h  
		      System.out.println("-------------------");
		      String s7="Sachin";  
		      System.out.println(s7.length());//6 
		      System.out.println("-------------------");
		      String s8=new String("Sachin");  
		      String s9=s8.intern();  
		      System.out.println(s9);//Sachin  
		      System.out.println("-------------------");
		      int a=10;  
		      String s10=String.valueOf(a);  
		      System.out.println(s10+10);
		      System.out.println("-------------------");
		      String s1="Java is a programming language. Java is a platform. Java is an Island.";    
		      String replacedString=s1.replace("Java","Kava");//replaces all occurrences of "Java" to "Kava"    
		      System.out.println(replacedString);  
		      System.out.println("-------------------");
	}

}
