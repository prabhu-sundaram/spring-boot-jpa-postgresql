package com.dm.springbootjpapostgresql.example.arrayPkg;

public class Test {

	public static void main(String[] args) {
		String	inputString =  "sdsfsf,dssdas";
		
	String array[]=inputString.split(",");
	
	String[]	recipientsEmails = new String[array.length];
	
	for(int i=0;i<array.length;i++)
	{
		recipientsEmails[i]=array[i];
		System.out.println(recipientsEmails[i]);
		
	}

	}

}
