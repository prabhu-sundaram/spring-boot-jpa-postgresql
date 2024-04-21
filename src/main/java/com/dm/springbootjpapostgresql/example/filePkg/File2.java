package com.dm.springbootjpapostgresql.example.filePkg;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class File2 {

	public static void main(String[] args) throws IOException, URISyntaxException {

	    //String expectedData = "Hello, world!";
	    
	    
	    whenReadWithFileChannel_thenCorrect();
	    givenURLName_whenUsingURL_thenFileData();
	}

	public static void whenReadWithFileChannel_thenCorrect()
			  throws IOException {
		System.out.println("------------------------Reading with FileChannel----------------------");
		
			    String expected_value = "Hello, world!";
			    String file = "src/main/resources/example/fileTest.txt";
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
	public static void givenURLName_whenUsingURL_thenFileData() throws IOException {
		System.out.println("------------------------Reading Content from URL----------------------");
		
	    String expectedData = "Baeldung";

//	    URL urlObject = new URL("/");
//	    URLConnection urlConnection = urlObject.openConnection();
//	    InputStream inputStream = urlConnection.getInputStream();
//	    String data = readFromInputStream(inputStream);
//	    System.out.println("data:"+data);

	}	
}
