package com.dm.springbootjpapostgresql.example.patternMatching;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatching {

	public static void main(String[] args) {
		String emailAddress = "asprabhueee@gmail.com";
		String EMAIL_PATTERN =
		        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(emailAddress);
		System.out.println(matcher.matches());
		
		//			String timePattern = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$";

		
	}

}
