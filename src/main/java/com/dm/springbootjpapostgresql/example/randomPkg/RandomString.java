package com.dm.springbootjpapostgresql.example.randomPkg;

import java.nio.charset.Charset;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomString {

	public static void main(String[] args) {
		System.out.println("--------------Generate Random Unbounded String With Plain Java----------------");
	    byte[] array = new byte[7]; // length is bounded by 7
	    new Random().nextBytes(array);
	    String generatedString = new String(array, Charset.forName("UTF-8"));

	    System.out.println(generatedString);
		System.out.println("------------------------------");
	    
	    System.out.println("--------------Generate Random Bounded String With Plain Java----------------");
	    int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString2 = buffer.toString();

	    System.out.println(generatedString2);
	    		
		System.out.println("------------------------------");
		System.out.println("------------Generate Random Alphabetic String With Java 8------------------");
		/*
		 * int leftLimit = 97; // letter 'a' int rightLimit = 122; // letter 'z' int
		 * targetStringLength = 10;
		 */
	    
	    Random random3 = new Random();

	    String generatedString3 = random3.ints(leftLimit, rightLimit + 1)
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();

	    System.out.println(generatedString3);		
		
		System.out.println("------------------------------");
		System.out.println("-------------Generate Random Alphanumeric String With Java 8-----------------");
	    int leftLimit4 = 48; // numeral '0'
	    int rightLimit4 = 122; // letter 'z'
	    //int targetStringLength = 10;
	    Random random4 = new Random();

	    String generatedString4 = random4.ints(leftLimit4, rightLimit4 + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();

	    System.out.println(generatedString4);		
		
		System.out.println("------------------------------");
		System.out.println("--------------Generate Bounded Random String With Apache Commons Lang----------------");
	    int length = 10;
	    boolean useLetters = true;
	    boolean useNumbers = false;
	    String generatedString5 = RandomStringUtils.random(length, useLetters, useNumbers);

	    System.out.println(generatedString5);		
		
		System.out.println("------------------------------");
		System.out.println("----------------Generate Alphabetic String With Apache Commons Lang--------------");
		
	    String generatedString6 = RandomStringUtils.randomAlphabetic(10);

	    System.out.println(generatedString6);		
		
		System.out.println("------------------------------");
		System.out.println("--------------Generate Alphanumeric String With Apache Commons Lang----------------");
	    String generatedString7 = RandomStringUtils.randomAlphanumeric(10);

	    System.out.println(generatedString7);
		
		System.out.println("------------------------------");
		System.out.println("------------------------------");
	}

}
