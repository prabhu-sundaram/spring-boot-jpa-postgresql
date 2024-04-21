package com.dm.springbootjpapostgresql.example.timePkg;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time3 {

	public static void main(String[] args) {
		String	agencyToken = "34973643189919981658790120700313190753636444474245516834758958323988461811447772306091309724198212528182090525240514475714329462";
		String	agencyTokenTime = "1620912963803";
		String	AGENCY_TOKEN_TIMEOUT = "300000";
		String isValid="false";
		if(agencyToken != null && (System.currentTimeMillis() - Long.parseLong(agencyTokenTime) )< Long.parseLong(AGENCY_TOKEN_TIMEOUT) ){
			agencyToken= agencyToken;
			isValid="true";
		}
		System.out.println(isValid);
		System.out.println("----------------------------");

		DateFormat df = new SimpleDateFormat("yyyy");
		String formattedDate = df.format(new Date());
		String messageId = formattedDate + System.currentTimeMillis();
		System.out.println("messageId:" + messageId);
		System.out.println("----------------------------");

		
	}

}
