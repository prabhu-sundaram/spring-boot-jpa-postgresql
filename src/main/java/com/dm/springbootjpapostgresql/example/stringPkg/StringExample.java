package com.dm.springbootjpapostgresql.example.stringPkg;

public class StringExample {

	public static void main(String[] args) {
		char[] ch={'j','a','v','a','t','p','o','i','n','t'};  
		String s=new String(ch); 
		System.out.println(s);
		String s2="javatpoint";  
		System.out.println(s2);
		System.out.println("-------------------");

		String s11="java";//creating string by java string literal  
		char ch2[]={'s','t','r','i','n','g','s'};  
		String s12=new String(ch2);//converting char array to string  
		String s13=new String("example");//creating java string by new keyword  
		System.out.println(s11);  
		System.out.println(s12);  
		System.out.println(s13); 
		
	      System.out.println("--------concat-----------");

		  String s4="Sachin";  
		   s4.concat(" Tendulkar");//concat() method appends the string at the end  
		   System.out.println(s4);//will print Sachin because strings are immutable objects  	
		   
		   String s5="Sachin";  
		   s5=s5.concat(" Tendulkar");  
		   System.out.println(s5);  
		   
		      System.out.println("-------------------");
		      System.out.println("--------equals-----------");

		   String s21="Sachin";  
		   String s22="Sachin";  
		   String s23=new String("Sachin");  
		   String s24="Saurav";  
		   System.out.println(s21.equals(s22));//true  
		   System.out.println(s21.equals(s23));//true  
		   System.out.println(s21.equals(s24));//false  
		   
		      System.out.println("-------------------");
		      System.out.println("--------equalsIgnoreCase-----------");

		   String s31="Sachin";  
		   String s32="SACHIN";  
		  
		   System.out.println(s31.equals(s32));//false  
		   System.out.println(s31.equalsIgnoreCase(s32));//true  
		      System.out.println("-------------------");
		      System.out.println("--------====================-----------");

		      String s41="Sachin";  
		      String s42="Sachin";  
		      String s43=new String("Sachin");  
		      System.out.println(s41==s42);//true (because both refer to same instance)  
		      System.out.println(s41==s43);//false(because s3 refers to instance created in nonpool)  
		      System.out.println("-------------------");
		      System.out.println("--------compareTo-----------");

		      String s51="Sachin";  
		      String s52="Sachin";  
		      String s53="Ratan";  
		      System.out.println(s51.compareTo(s52));//0  
		      System.out.println(s51.compareTo(s53));//1(because s1>s3)  
		      System.out.println(s53.compareTo(s51));//-1(because s3 < s1 )  
		      System.out.println("-------------------");
		      System.out.println("--------++++++++++,append,concat-----------");

		      String s54="Sachin"+" Tendulkar";  
		      System.out.println(s54);//Sachin Tendulkar  
		      String s55=(new StringBuilder()).append("Sachin").append(" Tendulkar").toString();  
		    		  System.out.println(s55);
		    		  
		    		  String s56=50+30+"Sachin"+40+40;  
		    		   System.out.println(s56);//80Sachin4040  		    		  
		    		   String s61="Sachin ";  
		    		   String s62="Tendulkar";  
		    		   String s63=s61.concat(s62);  
		    		   System.out.println(s63);//Sachin Tendulkar  
	}

}
