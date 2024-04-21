package com.dm.springbootjpapostgresql.example.stringPkg;

import java.util.StringTokenizer;

public class StringTokenizerExample {

	public static void main(String[] args) {
		   StringTokenizer st = new StringTokenizer("my name is khan"," ");  
		     while (st.hasMoreTokens()) {  
		         System.out.println(st.nextToken()); 

	}

		       StringTokenizer st2 = new StringTokenizer("my,name,is,khan");  
		        
		       // printing next token  
		       System.out.println("Next token is : " + st2.nextToken(","));  		     
}
}