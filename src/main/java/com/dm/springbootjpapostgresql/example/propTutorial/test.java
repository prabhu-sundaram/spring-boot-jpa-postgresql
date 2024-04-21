package com.dm.springbootjpapostgresql.example.propTutorial;

import java.io.FileNotFoundException;
import java.io.IOException;

public class test {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		  //Get individual properties
		  System.out.println(PropertiesCache.getInstance().getProperty("firstName"));
		  System.out.println(PropertiesCache.getInstance().getProperty("lastName"));
		   
		  //All property names
		  System.out.println(PropertiesCache.getInstance().getAllPropertyNames());
		  
		  PropertiesCache cache = PropertiesCache.getInstance();
		  if(cache.containsKey("country") == false){
		   cache.setProperty("country", "INDIA");
		  }
		//Verify property
		  System.out.println(cache.getProperty("country")); 
		   
		  //Write to the file
		  PropertiesCache.getInstance().flush(); 

		  //All property names
		  System.out.println(PropertiesCache.getInstance().getAllPropertyNames());		  
	}

}
