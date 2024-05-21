package com.dm.springbootjpapostgresql.service.FileOps;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FileReadService {

    @Value("${file.inputLocation}")
    private String inputLocation;	

	public void testFileRead() throws Exception {
	
		System.out.println("------------------------Reading a Small File ----------------------");

		Path path = Paths.get(inputLocation+File.separator+"fileTest.txt");

		String read = Files.readAllLines(path).get(0);
		System.out.println("read:"+read);	
		System.out.println("-----------------------");		    
   
		System.out.println("------------------------Reading a Large File ----------------------");	    
		
		BufferedReader reader = Files.newBufferedReader(path);
		String line = reader.readLine();
		System.out.println("line:"+line);	   
		System.out.println("-----------------------");	

		System.out.println("------------------------Reading a File Using Files.lines()----------------------");	    

		System.out.println("------------------------Reading a File from the Classpath----------------------");
	         
		//	    Path path = Paths.get(getClass().getClassLoader().getResource("fileTest.txt").toURI());
		//	         
		//	    Stream<String> lines = Files.lines(path);
		//	    String data = lines.collect(Collectors.joining("\n"));
		//	    lines.close();
		//	         
		//	    System.out.println("data:"+data);
		System.out.println("-----------------------");

	    System.out.println("----------Files.readAllLines-------------");
	    List<String> l = readFileInList(inputLocation+File.separator+"file4.txt");
	    
	    Iterator<String> it = l.iterator();
	    while(it.hasNext())
	    {
	    	System.out.println(it.next());
	    }
	    
	    System.out.println("-----------------------");	    
	    
	    System.out.println("----------Files.readAllBytes-------------");		  	    
	    System.out.println(readFileAsString(inputLocation+File.separator+"file4.txt"));
	    System.out.println("-----------------------");

	}
	
	  public List<String> readFileInList(String fileName)
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
	  
	  public String readFileAsString(String fileName)throws Exception
	  {
	    String data = "";
	    data = new String(Files.readAllBytes(Paths.get(fileName)));
	    return data;
	  }	

	public void readWithFileChannel() throws IOException {
		System.out.println("------------------------Reading with FileChannel----------------------");
		
			    String file = inputLocation+File.separator+"fileTest.txt";
			    RandomAccessFile reader = new RandomAccessFile(file, "r");
			    FileChannel channel = reader.getChannel();

			    int bufferSize = 1024;
			    if (bufferSize > channel.size()) {
			        bufferSize = (int) channel.size();
			    }
			    ByteBuffer buff = ByteBuffer.allocate(bufferSize);
			    channel.read(buff);
			    buff.flip();
			    System.out.println("result:"+new String(buff.array()));
			   
			    channel.close();
			    reader.close();
			}	

	public void readContentFromURL() throws IOException {
		System.out.println("------------------------Reading Content from URL----------------------");
		
	    // URL urlObject = new URL("/");
	    // URLConnection urlConnection = urlObject.openConnection();
	    // InputStream inputStream = urlConnection.getInputStream();
	    // String data = readFromInputStream(inputStream);
	    // System.out.println("data:"+data);

	}	
	public void readWithReader() throws Exception {

		System.out.println("---------FileReader-------------");
		FileReader fr = new FileReader(inputLocation+File.separator+"sample.txt");
		
		int i;
		while((i = fr.read()) != -1)
		{
			//System.out.println((char) i);
			System.out.print((char) i);
		}
		fr.close();
		System.out.println("-----------------------");
		
		System.out.println("---------FileReader 2-------------");
		Reader fr2 = new FileReader(inputLocation+File.separator+"sample.txt");
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
		FileReader fr3 = new FileReader(inputLocation+File.separator+"sample.txt");

		char[] destination = new char[1024];

		int charsRead = fr3.read(destination, 0, destination.length);
		System.out.println("charsRead:"+charsRead);
		System.out.println("charsRead:"+(char)charsRead);
		fr3.close();
		System.out.println("-----------------------");
		
		System.out.println("-----------BufferedReader------------");
		
		File file = new File(inputLocation+File.separator+"car.json");
		BufferedReader br = new BufferedReader(new FileReader(file));
		System.out.println("result:"+br.readLine());
		br.close();
		System.out.println("-----------------------");
		
		System.out.println("-----------BufferedReader 2------------");
		File file22 = new File(inputLocation+File.separator+"sample.txt");
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
		
		File file2 = new File(inputLocation+File.separator+"sample.txt");
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

		String	fileLocation = inputLocation+File.separator+"1234567890Payload.xml";
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
		String file23 =inputLocation+File.separator+"fileTest.txt";
		
		BufferedReader reader = new BufferedReader(new FileReader(file23));
		String currentLine = reader.readLine();
		   System.out.println("currentLine:"+currentLine);	   
		
		reader.close();
		
		System.out.println("-----------------------");		
		System.out.println("-----------BufferedReader -Reader - buff------------");
		
		Reader input = new BufferedReader(new FileReader(inputLocation+File.separator+"sample.txt"),1024 * 1024);/* buffer size */
		
		int  i6=input.read();
		while(i6 != -1)
		{
			System.out.println(""+(char)i6);
			i6=input.read();
		}
		input.close();
		
		System.out.println("-----------------------");
    
		System.out.println("-----------Scanner 1 --next------------");
	    
		File file4 = new File(inputLocation+File.separator+"file4.txt");

	    Scanner sc2 = new Scanner(file4);
	    sc2.useDelimiter(",");   
	    System.out.println(sc2.next());
	    System.out.println(sc2.next());
	    System.out.println(sc2.next());
	    //System.out.println(sc2.next());
	    sc2.close();
	    System.out.println("-----------------------");  
		System.out.println("------------------------Reading with Scanner --hasNext-- next----------------------");

		String file24 = inputLocation+File.separator+"fileTest.txt";
		Scanner scanner = new Scanner(new File(file24));
		scanner.useDelimiter(" ");

		while(scanner.hasNext())
		{
			System.out.println(scanner.next());
		}

		scanner.close();
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
            File f2 = new File(inputLocation+File.separator+"1234567890Payload.xml");    
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
}
