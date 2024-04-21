package com.dm.springbootjpapostgresql.example.filePkg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FileReader4 {

	public static void main(String[] args) throws Exception {


		System.out.println("---------FileReader-------------");
		FileReader fr = new FileReader("src/main/resources/example/sample.txt");
		
		int i;
		while((i = fr.read()) != -1)
		{
			//System.out.println((char) i);
			System.out.print((char) i);
		}
		fr.close();
		System.out.println("-----------------------");
		
		System.out.println("---------FileReader 2-------------");
		Reader fr2 = new FileReader("src/main/resources/example/sample.txt");
		int i2 = fr2.read();
		while(i2 != -1)
		{
			//System.out.print(i2);
			System.out.print((char)i2);
			i2 = fr2.read();
		}
		fr2.close();
		System.out.println("-----------------------");
		
		System.out.println("---------FileReader 3-------------");		
		FileReader fr3 = new FileReader("src/main/resources/example/sample.txt");

		char[] destination = new char[1024];

		int charsRead = fr3.read(destination, 0, destination.length);
		System.out.println("charsRead:"+charsRead);
		System.out.println("charsRead:"+(char)charsRead);
		fr3.close();
		System.out.println("-----------------------");
		
		System.out.println("-----------BufferedReader------------");
		
		File file = new File("src/main/resources/example/car.json");
		BufferedReader br = new BufferedReader(new FileReader(file));
		System.out.println("result:"+br.readLine());
		br.close();
		System.out.println("-----------------------");
		
		System.out.println("-----------BufferedReader 2------------");
		File file22 = new File("src/main/resources/example/sample.txt");
		BufferedReader br22 = new BufferedReader(new FileReader(file22));
		//System.out.println("result:"+br22.read());		
		
		int i22 = br22.read();
		while(i22 != -1)
		{
			System.out.println("i22:"+(char)i22);
			i22 = br22.read();
		}
		br22.close();
		System.out.println("-----------------------");	
		System.out.println("-----------BufferedReader 3------------");
		
		File file2 = new File("src/main/resources/example/sample.txt");
		BufferedReader br2 = new BufferedReader(new FileReader(file2));
		System.out.println("result:"+br2.readLine());		
		
		String st;
		while((st = br2.readLine()) != null)
		{
			System.out.println("st:"+st);
		}
		br2.close();
		System.out.println("-----------------------");		
		System.out.println("-----------BufferedReader 4------------");

		String	fileLocation = "src/main/resources/example/1234567890Payload.xml";
		  File file5 = new File(fileLocation ); 
		  String payload="";
	
		try 
		{
			
			  BufferedReader br5 = new BufferedReader(new FileReader(file5)); 
			  String st5; 
			  while ((st5 = br5.readLine()) != null) 
			  {
				  payload=payload+st5+"\n";
			    System.out.println(st5); 
			  }
			  br5.close();
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        System.out.println("------------------------Reading with BufferedReader ----------------------");
	    whenReadWithBufferedReader_thenCorrect();
		
		System.out.println("-----------------------");		
		System.out.println("-----------BufferedReader -Reader - buff------------");
		
		Reader input = new BufferedReader(new FileReader("src/main/resources/example/sample.txt"),1024 * 1024);/* buffer size */
		
		int  i6=input.read();
		while(i6 != -1)
		{
			System.out.println(""+(char)i6);
			i6=input.read();
		}
		input.close();
		
		System.out.println("-----------------------");
    
		System.out.println("-----------Scanner 1 --next------------");
	    
		File file4 = new File("src/main/resources/example/file4.txt");

	    Scanner sc2 = new Scanner(file4);
	    sc2.useDelimiter(",");   
	    System.out.println(sc2.next());
	    System.out.println(sc2.next());
	    System.out.println(sc2.next());
	    //System.out.println(sc2.next());
	    sc2.close();
	    System.out.println("-----------------------");  
		System.out.println("------------------------Reading with Scanner --hasNext-- next----------------------");
		whenReadWithScanner_thenCorrect();
		System.out.println("-----------------------");
		
		System.out.println("-----------Scanner --hasNextLine-- nextLine------------");
	    // pass the path to the file as a parameter

	    Scanner sc = new Scanner(file2);
	  
	    while (sc.hasNextLine())
	      System.out.println(sc.nextLine());
	    sc.close();
	    System.out.println("-----------------------");	
	    
		System.out.println("-----------Scanner --hasNextLine-- nextLine------------");
	    
        try {  
            // Create f1 object of the file to read data  
            File f2 = new File("src/main/resources/example/1234567890Payload.xml");    
            Scanner dataReader = new Scanner(f2);  
            while (dataReader.hasNextLine()) {  
                String fileData = dataReader.nextLine();  
                System.out.println(fileData);  
            }  
            dataReader.close();  
        } catch (FileNotFoundException exception) {  
            System.out.println("Unexcpected error occurred!");  
            exception.printStackTrace();  
        }  
        System.out.println("--------------");
        

	}
	

		public static void whenReadWithBufferedReader_thenCorrect()
				  throws IOException {
			
				     String expected_value = "Hello, world!";
				     String file ="src/main/resources/example/fileTest.txt";
				     
				     BufferedReader reader = new BufferedReader(new FileReader(file));
				     String currentLine = reader.readLine();
					    System.out.println("currentLine:"+currentLine);	   
				     
				     reader.close();

				}		
		public static void whenReadWithScanner_thenCorrect()
				  throws IOException {


				    String file = "src/main/resources/example/fileTest.txt";
				    Scanner scanner = new Scanner(new File(file));
				    scanner.useDelimiter(" ");

				    while(scanner.hasNext())
				    {
				    	System.out.println(scanner.next());
				    }

				    scanner.close();
				}			
}
