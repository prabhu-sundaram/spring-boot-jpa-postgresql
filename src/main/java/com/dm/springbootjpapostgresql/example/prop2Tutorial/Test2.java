package com.dm.springbootjpapostgresql.example.prop2Tutorial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Test2 {

	public static void main(String[] args) {
		String	token = "34973643189919981658790120700313190753636444474245516834758958323988461811447772306091309724198212528182090525240514475714329462--123";	
		long agencyTokenTime = System.currentTimeMillis();
		 
		String	fileLocation = "src/main/resources/example/AgencyAuth.properties";		
		
		   try (InputStream input = new FileInputStream(fileLocation)) 
		   {
			
		    Properties prop = new Properties();				
		
		    // load a properties file
		    prop.load(input);
		    
		    FileOutputStream out = new FileOutputStream(fileLocation);
	
		    prop.setProperty("agencyToken", token);
		    prop.setProperty("agencyTokenTime", Long.toString(agencyTokenTime));
		    prop.save(out, null);
		    out.close();
	
		    
		} 
		   catch (IOException ex) {
		    ex.printStackTrace();
		}

	}

}
