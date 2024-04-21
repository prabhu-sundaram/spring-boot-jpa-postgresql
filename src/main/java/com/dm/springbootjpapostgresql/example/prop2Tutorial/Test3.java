package com.dm.springbootjpapostgresql.example.prop2Tutorial;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class Test3 {

	public static void main(String[] args) {
		String	fileLocation = "src/main/resources/example/AgencyAuth.properties";
		String[]	propertyKeys = (new String[]{"agencyToken","AGENCY_TOKEN_TIMEOUT","agencyTokenTime"});

	
	//Defining ArrayList
	ArrayList<String> propertyValList = new ArrayList<String>();
	
	if(fileLocation!=null){
		//Business Logic
		try (InputStream input = new FileInputStream(fileLocation)) {
		
		    Properties prop = new Properties();
		
		    // load a properties file
		    prop.load(input);
		    
		    //Retrieving Property values and adding to an Array list
		    for(int i=0;i<propertyKeys.length;i++){
		    	propertyValList.add(prop.getProperty(propertyKeys[i]));
		    }
		    
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
	}
	

	String[]	propertyValues = new String[propertyValList.size()];
	
	for(int j=0;j<propertyValues.length;j++){
		propertyValues[j] = propertyValList.get(j);
		System.out.println(propertyKeys[j]+":"+ propertyValues[j]);

	}
	

	}

}
