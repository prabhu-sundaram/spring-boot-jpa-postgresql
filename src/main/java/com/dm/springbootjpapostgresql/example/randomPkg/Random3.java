package com.dm.springbootjpapostgresql.example.randomPkg;

import java.util.Random;

public class Random3 {

	public static void main(String[] args) {
		Integer targetLength=10;	
				
		String outputType = null;

	
		Random random = new Random();
		String generatedString=null;
		
		if(outputType=="Alphabetic")
		{
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		 
		//Generate Random Alphabetic String With Java 8
		generatedString = random.ints(leftLimit, rightLimit + 1)
		  .limit(targetLength)
		  .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
		  .toString();
	    System.out.println("Alphabetic random:"+generatedString);
		
		}
		else if (outputType==""||outputType==null||outputType=="Alphanumeric")
		{
		//Generate Random Alphanumeric String With Java 8
		int leftLimit2 = 48; // numeral '0'
		int rightLimit2 = 122; // letter 'z'
		
		generatedString = random.ints(leftLimit2, rightLimit2 + 1)
		  .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
		  .limit(targetLength)
		  .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
		  .toString();	    
	    System.out.println("Alphanumeric random:"+generatedString);

		}
		

	}

}
