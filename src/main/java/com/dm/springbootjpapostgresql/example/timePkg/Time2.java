package com.dm.springbootjpapostgresql.example.timePkg;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Time2 {

	public static void main(String[] args) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		final Calendar cal = Calendar.getInstance();
		String to_date=dateFormat.format(cal.getTime());
		System.out.println(to_date);
		
		cal.add(Calendar.DATE, -1);
		
		String from_date=dateFormat.format(cal.getTime());
		System.out.println(from_date);
		System.out.println("----------------------------");
		
		String	date = "2021-05-13 GST 03:11:20";
		//SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		
	    sdfrmt.setLenient(false);
	    Date javaDate;
		try {
			javaDate = sdfrmt.parse(date);
			System.out.println(javaDate);
		
	
		String isValid="false";
		
		
	 Calendar calendar = Calendar.getInstance();
	    calendar.setTime(javaDate);
	    calendar.add(Calendar.DAY_OF_YEAR, 0);
	
	    Date previousDate = calendar.getTime();
	  //  to_date('2020-10-18 04:25:03','YYYY-MM-dd hh24:mi:ss')
	 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	
	 String query1="to_date('"+formatter.format(previousDate)+"'"+","+"'YYYY-MM-dd hh24:mi:ss')";
		System.out.println(query1);
	 
	
	 formatter=new SimpleDateFormat("dd/MM/yyyy"); 
		System.out.println(formatter);

	
	} catch (java.text.ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 		

	}

}
