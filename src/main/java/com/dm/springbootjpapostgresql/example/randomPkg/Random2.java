package com.dm.springbootjpapostgresql.example.randomPkg;
import static java.lang.Math.abs;
import static java.lang.Math.min;
import static java.lang.Math.pow;
import static java.lang.Math.random;
import static java.lang.Math.round;

import org.apache.commons.lang3.StringUtils;


public class Random2 {

	public static void main(String[] args) {
		int length=23;
	    StringBuffer sb = new StringBuffer();
	    for (int i = length; i > 0; i -= 12) {
	      int n = min(12, abs(i));	  
	      //System.out.println("n:"+n);
	      //System.out.println("pow(36, n):"+pow(36, n));
	      //sb.append(StringUtils.leftPad(Long.toString(round(random() * pow(36, n)), 36), n, '0'));
	      String s2 = Long.toString(round(random() * pow(36, n)), 36);
	      sb.append(StringUtils.leftPad(s2, n, '0'));
	    }
		System.out.println("random:"+sb.toString());
		System.out.println("------------------------------");	
		
	    StringBuffer sb2 = new StringBuffer();
	    for (int i = length; i > 0; i -= 12) {
	      int n = min(12, abs(i));	  
	      //System.out.println("n:"+n);
	      //System.out.println("pow(36, n):"+pow(36, n));
	      String s22 = Long.toString(round(random() * pow(36, n)), 36);
	      sb2.append(StringUtils.leftPad(s22, n, '0'));	      
	    }
		String sb2String = sb2.toString();
		System.out.println("sb2String:"+sb2String);	
		
		StringBuilder sb3 = new StringBuilder();
		for (int i = 0; i < length; i++) {
		    sb3.append('0');
		}
		System.out.println(sb3.toString());
		//String sb3String = sb3.toString();
		
		String randomString = sb3.substring(sb2String.length()) + sb2String;
		System.out.println("randomString:"+randomString);
		System.out.println("------------------------------");	

		
	}

}
