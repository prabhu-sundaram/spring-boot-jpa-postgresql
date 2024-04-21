package com.dm.springbootjpapostgresql.example.encodeDecode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.codec.binary.Base64;


public class EncodeFileToBase64Binary {

	public static void main(String[] args) {
		try {		
		String	FilePath = "src/main/resources/example/sample.txt";
	
	    File file = new File(FilePath);
	    InputStream is;
	

			is = new FileInputStream(file);

	
	
	    long length = file.length();
	    if (length > Integer.MAX_VALUE) {
	        // File is too large
	    }
	    byte[] bytes = new byte[(int)length];
	
	    int offset = 0;
	    int numRead = 0;
	    try 
	    {
			while (offset < bytes.length
			       && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) 
			{
			    offset += numRead;
			}
		} 
	    catch (IOException e1) 
	    {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	    if (offset < bytes.length) {
	        try {
				throw new IOException("Could not completely read file "+file.getName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	
	    is.close();
	    System.out.println("Sucessfully able to read the file!!!");
		
		//byte[] bytes = loadFile(file);
		//byte[] encoded = Base64.encodeBase64(bytes);
		//String encodedString = new String(encoded);
		String encodedString = Base64.encodeBase64URLSafeString(bytes);
		System.out.println("encodedString:"+encodedString);
		
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
