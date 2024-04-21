package com.dm.springbootjpapostgresql.example.encodeDecode;

import org.apache.commons.codec.binary.Base64;

public class EncodeDecodeBase64Apache {

	public static void main(String[] args) {
		String originalInput = "test input";

		//Encoding/Decoding Using Apache Commons Code
		Base64 base64 = new Base64();
		String encodedString3 = new String(base64.encode(originalInput.getBytes()));
		System.out.println("encodedString3:"+encodedString3);
		String decodedString3 = new String(base64.decode(encodedString3.getBytes()));		
		System.out.println("decodedString3:"+decodedString3);
		
		String encodedString4 = new String(Base64.encodeBase64(originalInput.getBytes()));
		System.out.println("encodedString4:"+encodedString4);
		String decodedString4 = new String(Base64.decodeBase64(encodedString4.getBytes()));
		System.out.println("decodedString4:"+decodedString4);
	}

}
