package com.dm.springbootjpapostgresql.example.encodeDecode;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

import jakarta.xml.bind.DatatypeConverter;

//import org.junit.Test;

//import org.apache.commons.codec.binary.Base64;

public class EncodeDecodeBase64 {
//@Test
	public static void main(String[] args) {
		
		//Java 8 Basic Base64
	String originalInput = "test input";
	System.out.println("originalInput:"+originalInput);
	System.out.println("bytes:"+originalInput.getBytes());
	System.out.println("bytes utf8:"+originalInput.getBytes(StandardCharsets.UTF_8));
	System.out.println("bytes US_ASCII:"+originalInput.getBytes(StandardCharsets.US_ASCII));

	
	String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
	System.out.println("Base64 encodedString:"+encodedString);
	
	byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
	String decodedString = new String(decodedBytes);
	System.out.println("decodedString:"+decodedString);
	
	System.out.println("-------------------------------------");
	//Java 8 Base64 Encoding Without Padding
	String encodedString2 = 
			  Base64.getEncoder().withoutPadding().encodeToString(originalInput.getBytes());
	System.out.println("Base64 Encoding Without Padding:"+encodedString2);
	System.out.println("decoded string2:"+Base64.getDecoder().decode(encodedString2).toString());
	System.out.println("-------------------------------------");
	
	//Java 8 URL Encoding
	String originalUrl = "https://www.google.co.nz/?gfe_rd=cr&ei=dzbFV&gws_rd=ssl#q=java";
	String encodedUrl = Base64.getUrlEncoder().encodeToString(originalUrl.getBytes());
	System.out.println("encodedUrl:"+encodedUrl);
	byte[] decodedBytes2 = Base64.getUrlDecoder().decode(encodedUrl);
	String decodedUrl = new String(decodedBytes2);
	System.out.println("decodedUrl:"+decodedUrl);
	System.out.println("-------------------------------------");
	
	//Java 8 MIME Encoding
	
	StringBuilder buffer = getMimeBuffer();
	byte[] encodedAsBytes = buffer.toString().getBytes();
	String encodedMime = Base64.getMimeEncoder().encodeToString(encodedAsBytes);
	System.out.println("encodedMime:"+encodedMime);
	
	byte[] decodedBytes3 = Base64.getMimeDecoder().decode(encodedMime);
	String decodedMime = new String(decodedBytes3);
	System.out.println("decodedMime:"+decodedMime);
	System.out.println("-------------------------------------");
	

//Converting a String to a byte Array
	byte[] result = originalInput.getBytes();
	System.out.println("result:"+result);
	System.out.println("result.length:"+result.length);
	System.out.println("originalInput.length:"+originalInput.length());

	//assertEquals(originalInput.length(), result.length);
	
	byte[] result2 = originalInput.getBytes(StandardCharsets.UTF_16);
	System.out.println("result2.length:"+result2.length);

	//assertTrue(originalInput.length() < result2.length);
	
	//Base64.getDecoder()
	String originalInputEn = "dGVzdCBpbnB1dA==";
	byte[] result3 = Base64.getDecoder().decode(originalInputEn);
	System.out.println("decode result3:"+result3);

	//assertEquals("test input", new String(result3));
	
	//DatatypeConverter.parseBase64Binary
	String originalInput4 = "dGVzdCBpbnB1dA==";
	byte[] result4 = DatatypeConverter.parseBase64Binary(originalInput4);
	System.out.println("decode result4:"+result4);
	
	//assertEquals("test input", new String(result4));
	
	//DatatypeConverter.parseHexBinary
	String originalInput5 = "7465737420696E707574";
	byte[] result5 = DatatypeConverter.parseHexBinary(originalInput5);
	System.out.println("decode result5:"+result5);

	//assertEquals("test input", new String(result5));
	
	}
	
	private static StringBuilder getMimeBuffer() {
	    StringBuilder buffer = new StringBuilder();
	    for (int count = 0; count < 10; ++count) {
	        buffer.append(UUID.randomUUID().toString());
	    }
	    return buffer;
	}
	
}
