package com.dm.springbootjpapostgresql.example.stringPkg;

import java.util.Arrays;

public class StringTest {

	public static void main(String[] args) {
		//contains
		String	string1 = "asdasds,dsdsafsd,sdsfsd";
		String	string2 = "dsdsafsd";
		String trueOrFalse="false";
		
	    String[] values = string1.split(",");
	    boolean contains =Arrays.stream(values).anyMatch(string2::equals);
	    if(contains)
	    	trueOrFalse="true";
	    else if(string1.contains(string2))
	    	trueOrFalse="true";

	    System.out.println(trueOrFalse);
		System.out.println("----------------------------");
		
		//removeAllTabfromString

		String	input = "1dsfsdf 2erfsdfsd	3esdfgd	4dgdfgdf ";

	input=input.trim();
	String output=input.replaceAll("[\t]", "");
    System.out.println(output);
	
	/*if(output.startsWith("bt"))
	{
		output=output.replaceFirst("bt", "");
		output=output.trim();
	}*/
	//input.replaceFirst(regex, replacement)
	//String output=input.replace('\t', ' ');
	//String output = input.replaceAll("[^a-zA-Z]+","");

	System.out.println("----------------------------");
	//removeTabfromString
	String	input2 = " bt1sdfdfd	2sdfsdfd	3dfdgfgf 4sfsdfds ";
    System.out.println(input2);

	input2=input2.trim();
	String output2=input2.replaceFirst("[\t]", "b");
    System.out.println(output2);
	
	if(output2.startsWith("bt"))
	{
		output2=output2.replaceFirst("bt", "");
		output2=output2.trim();
	}
    System.out.println(output2);
	
	//input.replaceFirst(regex, replacement)
	//String output=input.replace('\t', ' ');
	//String output = input.replaceAll("[^a-zA-Z]+","");
	System.out.println("----------------------------");
	//indexOf
	String	jsonInput = "json:{sfsdfsdfzsd}}";


int beginIndex=jsonInput.indexOf(":")+1;
int endIndex=jsonInput.lastIndexOf("}");
System.out.println(beginIndex);
System.out.println(endIndex);
String jsonOutput=jsonInput.substring(beginIndex, endIndex);
System.out.println(jsonOutput);
System.out.println("----------------------------");


String	fineDetails = "34343 343324fsdfsdfsd3";
String arr[]=fineDetails.split(" ");
System.out.println(arr[1]);
System.out.println(arr[0]);


	}

}
