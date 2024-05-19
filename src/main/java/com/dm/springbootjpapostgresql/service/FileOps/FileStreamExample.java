package com.dm.springbootjpapostgresql.service.FileOps;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.io.IOUtils;

public class FileStreamExample {

	public static void main(String[] args) throws IOException {
		System.out.println("------------------------FileInputStream----------------------");
		
		FileInputStream fis = new FileInputStream("src/main/resources/example/sample.txt");
		int i = fis.read();
		System.out.print((char)i);
		fis.close();
        System.out.println("--------------");
		System.out.println("------------------------FileInputStream----------------------");

		FileInputStream fis2 = new FileInputStream("src/main/resources/example/sample.txt");
		int i2=0;
		while((i2 = fis2.read()) != -1)
		{
			System.out.print((char)i2);	
		}
		
		fis2.close();
        System.out.println("--------------");
		System.out.println("------------------------BufferedInputStream----------------------");
        
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src/main/resources/example/sample.txt"));
		int i3=0;
		while((i3 = bis.read()) != -1)
		{
			System.out.print((char)i3);	
		}
		
		bis.close();        
        System.out.println("--------------");
        
		System.out.println("------------------------InputStreamReader----------------------");   
		InputStream is = new FileInputStream("src/main/resources/example/sample.txt");
		InputStreamReader isr = new InputStreamReader(is);
		int data = isr.read();
		while(data != -1)
		{
			System.out.print("data:"+(char)data);
			data = isr.read();
		}
		
        System.out.println("--------------");
		
		System.out.println("------------------------Using Standard Java----------------------");
		givenFileNameAsAbsolutePath_whenUsingClasspath_thenFileData();
		System.out.println("------------------------Using the commons-io Library----------------------");
		givenFileName_whenUsingFileUtils_thenFileData();
		System.out.println("------------------------Using the IOUtils ----------------------");
		givenFileName_whenUsingIOUtils_thenFileData();		
		System.out.println("------------------------Reading with DataInputStream----------------------");
		whenReadWithDataInputStream_thenCorrect();		
	
	}
	private static String readFromInputStream(InputStream inputStream)
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
	public static void givenFileNameAsAbsolutePath_whenUsingClasspath_thenFileData() throws IOException
	{
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
	public static void givenFileName_whenUsingFileUtils_thenFileData() throws IOException {

		System.out.println("------------------------Reading a File from the Classpath----------------------");
	        
//	    ClassLoader classLoader = getClass().getClassLoader();
//	    File file = new File(classLoader.getResource("src/main/resources/example/fileTest.txt").getFile());
//	    String data = FileUtils.readFileToString(file, "UTF-8");
	        
	    //System.out.println("data:"+data);	 

	}	
	public static void givenFileName_whenUsingIOUtils_thenFileData() throws IOException {
		
	    String expectedData = "Hello, world!";
	        
	    FileInputStream fis = new FileInputStream("src/main/resources/example/fileTest.txt");
	    String data = IOUtils.toString(fis, "UTF-8");
	    System.out.println("data:"+data);	   
	}
	public static void whenReadWithDataInputStream_thenCorrect() throws IOException {

	    String expectedValue = "Hello, world!";
	    String file ="src/main/resources/example/fileTest.txt";
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
