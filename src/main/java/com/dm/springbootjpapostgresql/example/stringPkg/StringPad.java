package com.dm.springbootjpapostgresql.example.stringPkg;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Strings;

public class StringPad {

	public static void main(String[] args) {
		String inputString="123456";
		int length=10;
		
		System.out.println("-------------StringBuilder-----------------");		

	    if (inputString.length() >= length) {
		    System.out.println(inputString);
	    }
	    else
	    {
	    StringBuilder sb = new StringBuilder();
	    while (sb.length() < length - inputString.length()) {
	        sb.append('0');
	    }
	    sb.append(inputString);

	    System.out.println(sb.toString());		
	    }
		System.out.println("------------------------------");		
	    
		System.out.println("--------------substring----------------");		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
		    sb.append(' ');
		}
		System.out.println(sb.toString());
		System.out.println(sb.substring(inputString.length()) + inputString);
		
		
		System.out.println("------------------------------");		
		System.out.println("-------------String.format-----------------");		

		System.out.println(String.format("%1$" + length + "s", inputString).replace(' ', '0'));
		
		System.out.println("------------------------------");		
		System.out.println("----------------Apache Commons Lang--------------");		
		System.out.println(StringUtils.leftPad("123456", 10));
		System.out.println(StringUtils.leftPad("123456", 10, "0"));
		
		
		System.out.println("------------------------------");		
		System.out.println("--------------Google Guava----------------");		
		System.out.println(Strings.padStart("123456", 10, ' '));
		System.out.println(Strings.padStart("123456", 10, '0'));
		
		
		System.out.println("------------------------------");		


	}

}
