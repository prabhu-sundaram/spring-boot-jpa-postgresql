package com.dm.springbootjpapostgresql.example.filePkg;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FilesExample {

	public static void main(String[] args) throws Exception {
		
		System.out.println("------------------------Reading a Small File ----------------------");
	    whenReadSmallFileJava7_thenCorrect();
	    System.out.println("-----------------------");	
	    
		System.out.println("------------------------Reading a Large File ----------------------");	    
	    whenReadLargeFileJava7_thenCorrect();
	    System.out.println("-----------------------");	
	    
		System.out.println("------------------------Reading a File Using Files.lines()----------------------");	    
	    givenFilePath_whenUsingFilesLines_thenFileData();
	    System.out.println("-----------------------");	    

	    System.out.println("----------Files.readAllLines-------------");
	    List<String> l = readFileInList("src/main/resources/example/file4.txt");
	    
	    Iterator<String> it = l.iterator();
	    while(it.hasNext())
	    {
	    	System.out.println(it.next());
	    }
	    
	    System.out.println("-----------------------");	    
	    
	    System.out.println("----------Files.readAllBytes-------------");		  	    
	    System.out.println(readFileAsString("src/main/resources/example/file4.txt"));
	    System.out.println("-----------------------");

	}
	public static void whenReadSmallFileJava7_thenCorrect()
			  throws IOException {
		
			    String expected_value = "Hello, world!";

			    Path path = Paths.get("src/main/resources/example/fileTest.txt");

			    String read = Files.readAllLines(path).get(0);
			    System.out.println("read:"+read);	   

			}	
	public static void whenReadLargeFileJava7_thenCorrect()
			  throws IOException {
		
			    String expected_value = "Hello, world!";

			    Path path = Paths.get("src/main/resources/example/fileTest.txt");

			    BufferedReader reader = Files.newBufferedReader(path);
			    String line = reader.readLine();
			    System.out.println("line:"+line);	   

			}	
	public static void givenFilePath_whenUsingFilesLines_thenFileData() throws URISyntaxException, IOException {
		
	    String expectedData = "Hello, world!";
		System.out.println("------------------------Reading a File from the Classpath----------------------");
	         
//	    Path path = Paths.get(getClass().getClassLoader().getResource("fileTest.txt").toURI());
//	         
//	    Stream<String> lines = Files.lines(path);
//	    String data = lines.collect(Collectors.joining("\n"));
//	    lines.close();
//	         
//	    System.out.println("data:"+data);
	}	
	
	  public static List<String> readFileInList(String fileName)
	  {
	  
	    List<String> lines = Collections.emptyList();
	    try
	    {
	      lines =
	       Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
	    }
	  
	    catch (IOException e)
	    {
	  
	      // do something
	      e.printStackTrace();
	    }
	    return lines;
	  }
	  
	  public static String readFileAsString(String fileName)throws Exception
	  {
	    String data = "";
	    data = new String(Files.readAllBytes(Paths.get(fileName)));
	    return data;
	  }
}
