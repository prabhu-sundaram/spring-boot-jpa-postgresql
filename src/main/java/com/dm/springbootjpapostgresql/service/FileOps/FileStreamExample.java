package com.dm.springbootjpapostgresql.service.FileOps;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FileStreamExample {
    @Value("${file.inputLocation}")
    private String inputLocation;	

	public void testFileReadStream() throws IOException {		
		System.out.println("------------------------FileInputStream----------------------");
		
		FileInputStream fis = new FileInputStream(inputLocation+File.separator+"sample.txt");
		int i = fis.read();
		System.out.print((char)i);
		fis.close();
        System.out.println("--------------");

		System.out.println("------------------------FileInputStream----------------------");
		FileInputStream fis2 = new FileInputStream(inputLocation+File.separator+"sample.txt");
		int i2=0;
		while((i2 = fis2.read()) != -1)
		{
			System.out.print((char)i2);	
		}
		
		fis2.close();
        System.out.println("--------------");

		System.out.println("------------------------BufferedInputStream----------------------");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputLocation+File.separator+"sample.txt"));
		int i3=0;
		while((i3 = bis.read()) != -1)
		{
			System.out.print((char)i3);	
		}
		
		bis.close();        
        System.out.println("--------------");
        
		System.out.println("------------------------InputStreamReader----------------------");   
		InputStream is = new FileInputStream(inputLocation+File.separator+"sample.txt");
		InputStreamReader isr = new InputStreamReader(is);
		int data = isr.read();
		while(data != -1)
		{
			System.out.print("data:"+(char)data);
			data = isr.read();
		}
		
        System.out.println("--------------");
			
	}
	private String readFromInputStream(InputStream inputStream)
			  throws IOException {
			    StringBuilder resultStringBuilder = new StringBuilder();
			    try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			        String line;
			        while ((line = br.readLine()) != null) {
			            resultStringBuilder.append(line).append("\n");
			        }
			    }
			  return resultStringBuilder.toString();
			}	
	public void testFileReadStreamClasspath() throws IOException
	{
		System.out.println("------------------------Using Standard Java----------------------");

		System.out.println("------------------------Reading a File from the Classpath----------------------");
		
	    Class clazz = FileReadService.class;
	    InputStream inputStream = clazz.getResourceAsStream("/fileTest.txt");
	    String data = readFromInputStream(inputStream);
	    System.out.println("data:"+data);
	    
//	    ClassLoader classLoader = getClass().getClassLoader();
//	    InputStream inputStream2 = classLoader.getResourceAsStream("fileTest.txt");
//	    String data2 = readFromInputStream(inputStream2);
//	    System.out.println("data:"+data2);
	    
//	    ClassLoader classLoader3 = File2.class;
//	    File file = new File(classLoader3.getResource("fileTest.txt").getFile());
//	    InputStream inputStream3 = new FileInputStream(file);
//	    String data3 = readFromInputStream(inputStream3);
//	    System.out.println("data:"+data3);	 
	}
	public void testFileReadStreamFileUtils() throws IOException {
		System.out.println("------------------------Using the commons-io Library----------------------");

		System.out.println("------------------------Reading a File from the Classpath----------------------");
	        
	    ClassLoader classLoader = getClass().getClassLoader();
	    File file = new File(classLoader.getResource(inputLocation+File.separator+"fileTest.txt").getFile());
	    String data = FileUtils.readFileToString(file, "UTF-8");
	        
	    System.out.println("data:"+data);	 

	}	
	public void testFileReadStreamIOUtils() throws IOException {
		System.out.println("------------------------Using the IOUtils ----------------------");
			        
	    FileInputStream fis = new FileInputStream(inputLocation+File.separator+"fileTest.txt");
	    String data = IOUtils.toString(fis, "UTF-8");
	    System.out.println("data:"+data);	   
	}
	public void testFileReadDataInputStream() throws IOException {
		System.out.println("------------------------Reading with DataInputStream----------------------");

	    String file =inputLocation+File.separator+"fileTest.txt";
	    String result = null;

	    DataInputStream reader = new DataInputStream(new FileInputStream(file));
	    int nBytesToRead = reader.available();
	    if(nBytesToRead > 0) {
	        byte[] bytes = new byte[nBytesToRead];
	        reader.read(bytes);
	        result = new String(bytes);
	    }

	    System.out.println("result:"+result);
	}	
}
