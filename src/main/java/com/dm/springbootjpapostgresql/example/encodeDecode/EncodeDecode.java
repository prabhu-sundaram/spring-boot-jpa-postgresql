package com.dm.springbootjpapostgresql.example.encodeDecode;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.binary.StringUtils;

public class EncodeDecode {

	public static void main(String[] args) {
		String enString = "Entwickeln Sie mit";
		System.out.println("enString:"+enString);
		byte[] enBytes = enString.getBytes();
		System.out.println("enBytes:"+enBytes);
		
		String asciiEncodedEnString = new String(enBytes, StandardCharsets.US_ASCII);
		
		System.out.println(asciiEncodedEnString+"--------" + enString);
		System.out.println("---------------------------------");
		
		String germanString = "Entwickeln Sie mit Vergnügen";
		System.out.println("germanString:"+germanString);
		byte[] germanBytes = germanString.getBytes();
		System.out.println("germanBytes:"+germanBytes);
		
		String asciiEncodedString = new String(germanBytes, StandardCharsets.US_ASCII);
		
		System.out.println(asciiEncodedString+"--------" + germanString);

		System.out.println("---------------------------------");
		
		//Encoding With Core Java
		String rawString = "Entwickeln Sie mit Vergnügen";
		byte[] bytes = rawString.getBytes(StandardCharsets.UTF_8);

		String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);

		System.out.println(rawString+"--------" + bytes+"--------"+utf8EncodedString);
		System.out.println("---------------------------------");
		
		//Encoding With Java 7 StandardCharsets
		String rawString2 = "Entwickeln Sie mit Vergnügen";
		ByteBuffer buffer = StandardCharsets.UTF_8.encode(rawString2); 

		String utf8EncodedString2 = StandardCharsets.UTF_8.decode(buffer).toString();

		System.out.println(rawString2+"--------"+ utf8EncodedString2);
		System.out.println("---------------------------------");
		
		//Encoding With Commons-Codec
		String rawString3 = "Entwickeln Sie mit Vergnügen"; 
		byte[] bytes3 = StringUtils.getBytesUtf8(rawString3);
		 
		String utf8EncodedString3 = StringUtils.newStringUtf8(bytes3);

		System.out.println(rawString3+"--------"+ bytes3+"--------"+ utf8EncodedString3);		
		System.out.println("---------------------------------");
		
		
	}

}
