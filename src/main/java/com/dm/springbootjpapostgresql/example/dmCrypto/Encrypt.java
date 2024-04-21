package com.dm.springbootjpapostgresql.example.dmCrypto;

import java.util.Hashtable;

public class Encrypt {

	public static void main(String[] args) {
		String	in0 = "prabhu";
	
	String EncryptReturn=new String("");
	
	 if (in0 != null) {
		 int nStringLength = in0.length();
		 char[] charArrayOrigString = in0.toCharArray();
		 int nKeyVal = 0;
		 while (nKeyVal > 3 || nKeyVal <= 0) {
			    nKeyVal = (int)(Math.random() * 10);
		 }
			  
		 
		 StringBuffer sbEncString = new StringBuffer(10 + nStringLength * 2);
		 
	      Hashtable<String, String> htKey1 = new Hashtable<String, String>();
	      htKey1.put("a", "2w"); htKey1.put("b", "j8"); htKey1.put("c", "0o"); htKey1.put("d", "4d");
	      htKey1.put("e", "6g"); htKey1.put("f", "4u"); htKey1.put("g", "u3"); htKey1.put("h", "s0");
	      htKey1.put("i", "y5"); htKey1.put("j", "8c"); htKey1.put("k", "i5"); htKey1.put("l", "8u");
	      htKey1.put("m", "v3"); htKey1.put("n", "3s"); htKey1.put("o", "1o"); htKey1.put("p", "4n");
	      htKey1.put("q", "s8"); htKey1.put("r", "d4"); htKey1.put("s", "a3"); htKey1.put("t", "3n");
	      htKey1.put("u", "x9"); htKey1.put("v", "r5"); htKey1.put("w", "9q"); htKey1.put("x", "s3");
	      htKey1.put("y", "0t"); htKey1.put("z", "l7"); htKey1.put("A", "y4"); htKey1.put("B", "2d");
	      htKey1.put("C", "4g"); htKey1.put("D", "t5"); htKey1.put("E", "4s"); htKey1.put("F", "4w");
	      htKey1.put("G", "q4"); htKey1.put("H", "9u"); htKey1.put("I", "p4"); htKey1.put("J", "4v");
	      htKey1.put("K", "s6"); htKey1.put("L", "2j"); htKey1.put("M", "a1"); htKey1.put("N", "5g");
	      htKey1.put("O", "m3"); htKey1.put("P", "5t"); htKey1.put("Q", "d2"); htKey1.put("R", "5d");
	      htKey1.put("S", "2q"); htKey1.put("T", "b5"); htKey1.put("U", "e2"); htKey1.put("V", "g6");
	      htKey1.put("W", "8j"); htKey1.put("X", "n4"); htKey1.put("Y", "6n"); htKey1.put("Z", "e3");
	      htKey1.put("1", "7f"); htKey1.put("2", "r1"); htKey1.put("3", "4q"); htKey1.put("4", "6x");
	      htKey1.put("5", "4i"); htKey1.put("6", "9l"); htKey1.put("7", "3e"); htKey1.put("8", "3z");
	      htKey1.put("9", "w3"); htKey1.put("0", "5r"); htKey1.put("-", "u5"); htKey1.put("_", "f4");
	      htKey1.put(".", "b4"); htKey1.put(",", "2l"); htKey1.put("/", "k5");
	      
	      Hashtable<String, String> htKey2 = new Hashtable<String, String>();
	      htKey2.put("a", "8b"); htKey2.put("b", "9x"); htKey2.put("c", "i4"); htKey2.put("d", "0d");
	      htKey2.put("e", "1i"); htKey2.put("f", "4u"); htKey2.put("g", "u8"); htKey2.put("h", "s3");
	      htKey2.put("i", "e2"); htKey2.put("j", "1t"); htKey2.put("k", "4f"); htKey2.put("l", "8u");
	      htKey2.put("m", "w9"); htKey2.put("n", "3s"); htKey2.put("o", "2d"); htKey2.put("p", "4n");
	      htKey2.put("q", "c4"); htKey2.put("r", "d4"); htKey2.put("s", "a1"); htKey2.put("t", "3n");
	      htKey2.put("u", "z2"); htKey2.put("v", "r5"); htKey2.put("w", "s9"); htKey2.put("x", "e3");
	      htKey2.put("y", "f2"); htKey2.put("z", "y1"); htKey2.put("A", "m5"); htKey2.put("B", "5b");
	      htKey2.put("C", "9i"); htKey2.put("D", "f5"); htKey2.put("E", "i9"); htKey2.put("F", "4w");
	      htKey2.put("G", "0o"); htKey2.put("H", "9u"); htKey2.put("I", "c6"); htKey2.put("J", "0x");
	      htKey2.put("K", "9q"); htKey2.put("L", "r4"); htKey2.put("M", "m2"); htKey2.put("N", "i1");
	      htKey2.put("O", "3w"); htKey2.put("P", "5t"); htKey2.put("Q", "v5"); htKey2.put("R", "u3");
	      htKey2.put("S", "2q"); htKey2.put("T", "s1"); htKey2.put("U", "g4"); htKey2.put("V", "i5");
	      htKey2.put("W", "8j"); htKey2.put("X", "n4"); htKey2.put("Y", "y4"); htKey2.put("Z", "y5");
	      htKey2.put("1", "7f"); htKey2.put("2", "w3"); htKey2.put("3", "r1"); htKey2.put("4", "4r");
	      htKey2.put("5", "4i"); htKey2.put("6", "e5"); htKey2.put("7", "c3"); htKey2.put("8", "a2");
	      htKey2.put("9", "x7"); htKey2.put("0", "3q"); htKey2.put("-", "1y"); htKey2.put("_", "z1");
	      htKey2.put(".", "6a"); htKey2.put(",", "0m"); htKey2.put("/", "k5");
	      
	      Hashtable<String, String> htKey3 = new Hashtable<String, String>();
	      htKey3.put("a", "c4"); htKey3.put("b", "1s"); htKey3.put("c", "4f"); htKey3.put("d", "v4");
	      htKey3.put("e", "o4"); htKey3.put("f", "n3"); htKey3.put("g", "n2"); htKey3.put("h", "n6");
	      htKey3.put("i", "b5"); htKey3.put("j", "2j"); htKey3.put("k", "l4"); htKey3.put("l", "h4");
	      htKey3.put("m", "2s"); htKey3.put("n", "3s"); htKey3.put("o", "k1"); htKey3.put("p", "4n");
	      htKey3.put("q", "8j"); htKey3.put("r", "5b"); htKey3.put("s", "3c"); htKey3.put("t", "2w");
	      htKey3.put("u", "4d"); htKey3.put("v", "a2"); htKey3.put("w", "w4"); htKey3.put("x", "o9");
	      htKey3.put("y", "c3"); htKey3.put("z", "8e"); htKey3.put("A", "v6"); htKey3.put("B", "4i");
	      htKey3.put("C", "6n"); htKey3.put("D", "b4"); htKey3.put("E", "r0"); htKey3.put("F", "a9");
	      htKey3.put("G", "1w"); htKey3.put("H", "7d"); htKey3.put("I", "3n"); htKey3.put("J", "4v");
	      htKey3.put("K", "q0"); htKey3.put("L", "e8"); htKey3.put("M", "h1"); htKey3.put("N", "5g");
	      htKey3.put("O", "5w"); htKey3.put("P", "3u"); htKey3.put("Q", "5j"); htKey3.put("R", "5d");
	      htKey3.put("S", "a1"); htKey3.put("T", "i2"); htKey3.put("U", "9e"); htKey3.put("V", "6g");
	      htKey3.put("W", "s2"); htKey3.put("X", "k6"); htKey3.put("Y", "7h"); htKey3.put("Z", "f7");
	      htKey3.put("1", "f4"); htKey3.put("2", "j5"); htKey3.put("3", "4q"); htKey3.put("4", "7q");
	      htKey3.put("5", "r6"); htKey3.put("6", "j3"); htKey3.put("7", "3e"); htKey3.put("8", "q1");
	      htKey3.put("9", "a3"); htKey3.put("0", "h5"); htKey3.put("-", "4p"); htKey3.put("_", "4m");
	      htKey3.put(".", "k4"); htKey3.put(",", "7f"); htKey3.put("/", "k5");
	  
	      
	
	      for (int i = 0; i < charArrayOrigString.length; i++) {
	        if (i == 0) {
	          
	          sbEncString.append(String.valueOf(String.valueOf("").concat(String.valueOf(nKeyVal))).concat(String.valueOf("x")));
	          if (nKeyVal == 1)
	            sbEncString.append(htKey1.get(String.valueOf("").concat(String.valueOf(charArrayOrigString[i])))); 
	          if (nKeyVal == 2)
	            sbEncString.append(htKey2.get(String.valueOf("").concat(String.valueOf(charArrayOrigString[i])))); 
	          if (nKeyVal == 3) {
	            sbEncString.append(htKey3.get(String.valueOf("").concat(String.valueOf(charArrayOrigString[i]))));
	          }
	        }
	        else {
	          if (nKeyVal == 1)
	            sbEncString.append(htKey1.get(String.valueOf("").concat(String.valueOf(charArrayOrigString[i])))); 
	          if (nKeyVal == 2)
	            sbEncString.append(htKey2.get(String.valueOf("").concat(String.valueOf(charArrayOrigString[i])))); 
	          if (nKeyVal == 3) {
	            sbEncString.append(htKey3.get(String.valueOf("").concat(String.valueOf(charArrayOrigString[i]))));
	          }
	        } 
	      } 
	      if(sbEncString!=null)
				 EncryptReturn=sbEncString.toString();
	    } 
		System.out.println(EncryptReturn);

	}

}
