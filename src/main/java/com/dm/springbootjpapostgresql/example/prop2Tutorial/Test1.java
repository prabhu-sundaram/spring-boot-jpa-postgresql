package com.dm.springbootjpapostgresql.example.prop2Tutorial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class Test1 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		//From Properties Files
		String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		String appConfigPath = rootPath + "app.properties";
		String catalogConfigPath = rootPath + "catalog";

		Properties appProps = new Properties();
		appProps.load(new FileInputStream(appConfigPath));

		Properties catalogProps = new Properties();
		catalogProps.load(new FileInputStream(catalogConfigPath));

		  
		String appVersion = appProps.getProperty("version");
		System.out.println("appVersion:"+appVersion);
		        
		System.out.println("c1:"+catalogProps.getProperty("c1"));
		
		//Load From XML Files
		String rootPath2 = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		String iconConfigPath = rootPath2 + "icons.xml";
		Properties iconProps = new Properties();
		iconProps.loadFromXML(new FileInputStream(iconConfigPath));

		System.out.println("---------------------------------");
		System.out.println("fileIcon:"+iconProps.getProperty("fileIcon"));

		
		//Get Properties
		String appVersion2 = appProps.getProperty("version");
		String appName = appProps.getProperty("name", "defaultName");
		String appGroup = appProps.getProperty("group", "baeldung");
		String appDownloadAddr = appProps.getProperty("downloadAddr");

		System.out.println("---------------------------------");
		System.out.println("1.0"+ appVersion);
		System.out.println("TestApp"+ appName);
		System.out.println("baeldung"+ appGroup);
		System.out.println(appDownloadAddr);
		
		//float appVerFloat = (float) appProps.get("version");
		
		//Set Properties
		System.out.println("---------------------------------");
		appProps.setProperty("name", "NewAppName"); // update an old value
		appProps.setProperty("downloadAddr", "www.baeldung.com/downloads"); // add new key-value pair

		String newAppName = appProps.getProperty("name");
		System.out.println("NewAppName"+ newAppName);
		

		System.out.println("---------------------------------");
		        
		String newAppDownloadAddr = appProps.getProperty("downloadAddr");
		System.out.println("www.baeldung.com/downloads"+ newAppDownloadAddr);
		
		String version = appProps.getProperty("version");	
		System.out.println("version"+ version);
		/*
		 * appProps.put("version", 2); String versionNew =
		 * appProps.getProperty("version"); System.out.println("versionNew"+
		 * versionNew);
		 */

		//Remove Properties
		System.out.println("---------------------------------");
		
		String versionBeforeRemoval = appProps.getProperty("version");
		System.out.println("1.0"+ versionBeforeRemoval);

		appProps.remove("version");    
		String versionAfterRemoval = appProps.getProperty("version");
		System.out.println(versionAfterRemoval);
		
		//Store to Properties Files
		String newAppConfigPropertiesFile = rootPath + "newApp.properties";
		appProps.store(new FileWriter(newAppConfigPropertiesFile), "store to properties file");
		
		//Store to XML Files
		String newAppConfigXmlFile = rootPath + "newApp.xml";
		appProps.storeToXML(new FileOutputStream(newAppConfigXmlFile), "store to xml file");
		
		//Other Common Operations
		System.out.println("---------------------------------");
		
		appProps.list(System.out); // list all key-value pairs

		Enumeration<Object> valueEnumeration = appProps.elements();
		while (valueEnumeration.hasMoreElements()) {
		    System.out.println(valueEnumeration.nextElement());
		}
		System.out.println("---------------------------------");

		Enumeration<Object> keyEnumeration = appProps.keys();
		while (keyEnumeration.hasMoreElements()) {
		    System.out.println(keyEnumeration.nextElement());
		}

		int size = appProps.size();
		System.out.println("size:"+size);		
		
		//Default Property List
		System.out.println("---------------------------------");
		String rootPath3 = Thread.currentThread().getContextClassLoader().getResource("").getPath();

		String defaultConfigPath = rootPath3 + "default.properties";
		Properties defaultProps = new Properties();
		defaultProps.load(new FileInputStream(defaultConfigPath));

		String appConfigPath3 = rootPath3 + "app.properties";
		Properties appProps3 = new Properties(defaultProps);
		appProps3.load(new FileInputStream(appConfigPath3));

		String appVersion3 = appProps3.getProperty("version");
		String appName3 = appProps3.getProperty("name");
		String defaultSite3 = appProps3.getProperty("site");
		
		System.out.println("1.0"+ appVersion3);
		System.out.println("TestApp"+ appName3);
		System.out.println("www.google.com"+ defaultSite3);		
	}

}
