package com.dm.springbootjpapostgresql.example.filePkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileOps {

	public static void main(String[] args) {
        File f0 = new File("src/main/resources/example/file.txt");
        

        try {
			if (f0.createNewFile()) {  
			    System.out.println("File " + f0.getName() + " is created successfully.");  
 } else {  
			    System.out.println("File is already exist in the directory.");  
 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        
        System.out.println("--------------");
        
        
        // Creating file object  
        //File f1 = new File("D:FileOperationExample.txt");  
        File f1 = new File("src/main/resources/example/1234567890Payload.xml");
        if (f1.exists()) {  
            // Getting file name  
            System.out.println("The name of the file is: " + f1.getName());  
   
            // Getting path of the file   
            System.out.println("The absolute path of the file is: " + f1.getAbsolutePath());     
   
            // Checking whether the file is writable or not  
            System.out.println("Is file writeable?: " + f1.canWrite());    
   
            // Checking whether the file is readable or not  
            System.out.println("Is file readable " + f1.canRead());    
   
            // Getting the length of the file in bytes  
            System.out.println("The size of the file in bytes is: " + f1.length());    
        } else {  
            System.out.println("The file does not exist.");  
        }    
        
        System.out.println("--------------");

        
        try {  
            FileWriter fwrite = new FileWriter("src/main/resources/example/FileOperationExample.txt");  
            // writing the content into the FileOperationExample.txt file  
            fwrite.write("A named location used to store related information is referred to as a File.");   
       
            // Closing the stream  
            fwrite.close();   
            System.out.println("Content is successfully wrote to the file.");  
        } catch (IOException e) {  
            System.out.println("Unexpected error occurred");  
            e.printStackTrace();  
            }      
        
        System.out.println("--------------");



        File f3 = new File("src/main/resources/example/file.txt");   
        if (f3.delete()) {   
          System.out.println(f3.getName()+ " file is deleted successfully.");  
        } else {  
          System.out.println("Unexpected error found in deletion of the file.");  
        }   
        System.out.println("--------------");

	}

}
