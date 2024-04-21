package com.dm.springbootjpapostgresql.example.dmCrypto;

import java.util.Hashtable;

public class Decrypt {

	public static void main(String[] args) {
		String	in0 = "1x4nd42wj8s0x9";
	
	
	String DecryptReturn=new String("");
	
	
	if (in0 != null) {
		 int nStringLength = in0.length();
		 char[] charArrayCryptedString = in0.toCharArray();
		 int nKeyVal = 0;
		 StringBuffer sbEncString = new StringBuffer(nStringLength);
		
	      Hashtable<String, String> htKey1 = new Hashtable<String, String>();
	      htKey1.put("2w", "a"); htKey1.put("j8", "b"); htKey1.put("0o", "c"); htKey1.put("4d", "d");
	      htKey1.put("6g", "e"); htKey1.put("4u", "f"); htKey1.put("u3", "g"); htKey1.put("s0", "h");
	      htKey1.put("y5", "i"); htKey1.put("8c", "j"); htKey1.put("i5", "k"); htKey1.put("8u", "l");
	      htKey1.put("v3", "m"); htKey1.put("3s", "n"); htKey1.put("1o", "o"); htKey1.put("4n", "p");
	      htKey1.put("s8", "q"); htKey1.put("d4", "r"); htKey1.put("a3", "s"); htKey1.put("3n", "t");
	      htKey1.put("x9", "u"); htKey1.put("r5", "v"); htKey1.put("9q", "w"); htKey1.put("s3", "x");
	      htKey1.put("0t", "y"); htKey1.put("l7", "z"); htKey1.put("y4", "A"); htKey1.put("2d", "B");
	      htKey1.put("4g", "C"); htKey1.put("t5", "D"); htKey1.put("4s", "E"); htKey1.put("4w", "F");
	      htKey1.put("q4", "G"); htKey1.put("9u", "H"); htKey1.put("p4", "I"); htKey1.put("4v", "J");
	      htKey1.put("s6", "K"); htKey1.put("2j", "L"); htKey1.put("a1", "M"); htKey1.put("5g", "N");
	      htKey1.put("m3", "O"); htKey1.put("5t", "P"); htKey1.put("d2", "Q"); htKey1.put("5d", "R");
	      htKey1.put("2q", "S"); htKey1.put("b5", "T"); htKey1.put("e2", "U"); htKey1.put("g6", "V");
	      htKey1.put("8j", "W"); htKey1.put("n4", "X"); htKey1.put("6n", "Y"); htKey1.put("e3", "Z");
	      htKey1.put("7f", "1"); htKey1.put("r1", "2"); htKey1.put("4q", "3"); htKey1.put("6x", "4");
	      htKey1.put("4i", "5"); htKey1.put("9l", "6"); htKey1.put("3e", "7"); htKey1.put("3z", "8");
	      htKey1.put("w3", "9"); htKey1.put("5r", "0"); htKey1.put("u5", "-"); htKey1.put("f4", "_");
	      htKey1.put("b4", "."); htKey1.put("2l", ","); htKey1.put("k5", "/");
	      
	      Hashtable<String, String> htKey2 = new Hashtable<String, String>();
	      htKey2.put("8b", "a"); htKey2.put("9x", "b"); htKey2.put("i4", "c"); htKey2.put("0d", "d");
	      htKey2.put("1i", "e"); htKey2.put("4u", "f"); htKey2.put("u8", "g"); htKey2.put("s3", "h");
	      htKey2.put("e2", "i"); htKey2.put("1t", "j"); htKey2.put("4f", "k"); htKey2.put("8u", "l");
	      htKey2.put("w9", "m"); htKey2.put("3s", "n"); htKey2.put("2d", "o"); htKey2.put("4n", "p");
	      htKey2.put("c4", "q"); htKey2.put("d4", "r"); htKey2.put("a1", "s"); htKey2.put("3n", "t");
	      htKey2.put("z2", "u"); htKey2.put("r5", "v"); htKey2.put("s9", "w"); htKey2.put("e3", "x");
	      htKey2.put("f2", "y"); htKey2.put("y1", "z"); htKey2.put("m5", "A"); htKey2.put("5b", "B");
	      htKey2.put("9i", "C"); htKey2.put("f5", "D"); htKey2.put("i9", "E"); htKey2.put("4w", "F");
	      htKey2.put("0o", "G"); htKey2.put("9u", "H"); htKey2.put("c6", "I"); htKey2.put("0x", "J");
	      htKey2.put("9q", "K"); htKey2.put("r4", "L"); htKey2.put("m2", "M"); htKey2.put("i1", "N");
	      htKey2.put("3w", "O"); htKey2.put("5t", "P"); htKey2.put("v5", "Q"); htKey2.put("u3", "R");
	      htKey2.put("2q", "S"); htKey2.put("s1", "T"); htKey2.put("g4", "U"); htKey2.put("i5", "V");
	      htKey2.put("8j", "W"); htKey2.put("n4", "X"); htKey2.put("y4", "Y"); htKey2.put("y5", "Z");
	      htKey2.put("7f", "1"); htKey2.put("w3", "2"); htKey2.put("r1", "3"); htKey2.put("4r", "4");
	      htKey2.put("4i", "5"); htKey2.put("e5", "6"); htKey2.put("c3", "7"); htKey2.put("a2", "8");
	      htKey2.put("x7", "9"); htKey2.put("3q", "0"); htKey2.put("1y", "-"); htKey2.put("z1", "_");
	      htKey2.put("6a", "."); htKey2.put("0m", ","); htKey2.put("k5", "/");
	      
	      Hashtable<String, String> htKey3 = new Hashtable<String, String>();
	      htKey3.put("c4", "a"); htKey3.put("1s", "b"); htKey3.put("4f", "c"); htKey3.put("v4", "d");
	      htKey3.put("o4", "e"); htKey3.put("n3", "f"); htKey3.put("n2", "g"); htKey3.put("n6", "h");
	      htKey3.put("b5", "i"); htKey3.put("2j", "j"); htKey3.put("l4", "k"); htKey3.put("h4", "l");
	      htKey3.put("2s", "m"); htKey3.put("3s", "n"); htKey3.put("k1", "o"); htKey3.put("4n", "p");
	      htKey3.put("8j", "q"); htKey3.put("5b", "r"); htKey3.put("3c", "s"); htKey3.put("2w", "t");
	      htKey3.put("4d", "u"); htKey3.put("a2", "v"); htKey3.put("w4", "w"); htKey3.put("o9", "x");
	      htKey3.put("c3", "y"); htKey3.put("8e", "z"); htKey3.put("v6", "A"); htKey3.put("4i", "B");
	      htKey3.put("6n", "C"); htKey3.put("b4", "D"); htKey3.put("r0", "E"); htKey3.put("a9", "F");
	      htKey3.put("1w", "G"); htKey3.put("7d", "H"); htKey3.put("3n", "I"); htKey3.put("4v", "J");
	      htKey3.put("q0", "K"); htKey3.put("e8", "L"); htKey3.put("h1", "M"); htKey3.put("5g", "N");
	      htKey3.put("5w", "O"); htKey3.put("3u", "P"); htKey3.put("5j", "Q"); htKey3.put("5d", "R");
	      htKey3.put("a1", "S"); htKey3.put("i2", "T"); htKey3.put("9e", "U"); htKey3.put("6g", "V");
	      htKey3.put("s2", "W"); htKey3.put("k6", "X"); htKey3.put("7h", "Y"); htKey3.put("f7", "Z");
	      htKey3.put("f4", "1"); htKey3.put("j5", "2"); htKey3.put("4q", "3"); htKey3.put("7q", "4");
	      htKey3.put("r6", "5"); htKey3.put("j3", "6"); htKey3.put("3e", "7"); htKey3.put("q1", "8");
	      htKey3.put("a3", "9"); htKey3.put("h5", "0"); htKey3.put("p4", "-"); htKey3.put("4m", "_");
	      htKey3.put("k4", "."); htKey3.put("7f", ","); htKey3.put("k5", "/");
	      
	     
	      for (int i = 0; i < charArrayCryptedString.length; i += 2) {
	
	        
	        if (i == 0) {
	          
	          nKeyVal = Integer.parseInt(String.valueOf("").concat(String.valueOf(charArrayCryptedString[i])));
	        
	        }
	        else {
	          
	          if (nKeyVal == 1)
	            sbEncString.append(htKey1.get(String.valueOf(String.valueOf("").concat(String.valueOf(charArrayCryptedString[i]))).concat(String.valueOf(charArrayCryptedString[i + 1])))); 
	          if (nKeyVal == 2)
	            sbEncString.append(htKey2.get(String.valueOf(String.valueOf("").concat(String.valueOf(charArrayCryptedString[i]))).concat(String.valueOf(charArrayCryptedString[i + 1])))); 
	          if (nKeyVal == 3) {
	            sbEncString.append(htKey3.get(String.valueOf(String.valueOf("").concat(String.valueOf(charArrayCryptedString[i]))).concat(String.valueOf(charArrayCryptedString[i + 1]))));
	          }
	        } 
	      } 
	      if(sbEncString.length()>0)
				DecryptReturn=sbEncString.toString();
	    } 
	System.out.println(DecryptReturn);

	}

}
