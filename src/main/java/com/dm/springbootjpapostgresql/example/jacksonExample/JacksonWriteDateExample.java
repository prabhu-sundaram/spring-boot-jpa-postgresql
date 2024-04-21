package com.dm.springbootjpapostgresql.example.jacksonExample;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.dm.springbootjpapostgresql.example.beans.Car;
import com.dm.springbootjpapostgresql.example.beans.Car2;
import com.dm.springbootjpapostgresql.example.beans.Event;
import com.dm.springbootjpapostgresql.example.beans.Event2;
import com.dm.springbootjpapostgresql.example.beans.Request;

public class JacksonWriteDateExample {

	public static void main(String[] args) throws JsonProcessingException {
		System.out.println("-------------HandlingDateFormats-------------");		
		
		ObjectMapper objectMapper = new ObjectMapper();
		
        Car car = new Car("yellow", "renault");
		Request request = new Request(car,new Date());
		
		String carAsString = objectMapper.writeValueAsString(request);
		System.out.println("carAsString:"+carAsString);
		
	
		//Car2 car22 = new Car2("Toyato", 4, "Green", "Toyato", 1920, new Date(), true);
		Car2 car22 = new Car2();
		car22.setBrand("Toyato");
		car22.setDoors(4);
		car22.setColor("Green");
		car22.setType("Toyato");
		car22.setYear(2000);
		car22.setDate(new Date());
		car22.setStatus(true);
		String car22AsString = objectMapper.writeValueAsString(car22);
		System.out.println("car22AsString:"+car22AsString);
		
		Event event = new Event("ev1",new Date());
		System.out.println("event:"+event);
		
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
		objectMapper.setDateFormat(df);

		String carAsString2 = objectMapper.writeValueAsString(request);
		System.out.println("carAsString2:"+carAsString2);
		// output: {"car":{"color":"yellow","type":"renault"},"datePurchased":"2016-07-03 11:43 AM CEST"}

		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	    // StdDateFormat is ISO8601 since jackson 2.9
		objectMapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
	    String result = objectMapper.writeValueAsString(event);
		System.out.println("event ISO8601:"+result);

		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
		objectMapper.setDateFormat(df2);		
		
		String car22AsString2 = objectMapper.writeValueAsString(car22);
		System.out.println("car22AsString2:"+car22AsString2);
		
		String eventString = objectMapper.writeValueAsString(event);
		System.out.println("eventString:"+eventString);

		DateFormat df3 = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		objectMapper.setDateFormat(df3);
		
		String eventString3 = objectMapper.writeValueAsString(event);
		System.out.println("eventString3:"+eventString3);

		ObjectMapper objectMapper2 = new ObjectMapper();
		Event2 event2 = new Event2("bday",new Date());
		System.out.println("event2:"+event2.toString());

		String event2String = objectMapper2.writeValueAsString(event2);
		System.out.println("event2String:"+event2String);

		System.out.println("--------------------------");	
	    LocalDateTime date = LocalDateTime.of(2014, 12, 20, 2, 30);

	    ObjectMapper mapper = new ObjectMapper();
	    mapper.registerModule(new JavaTimeModule());
	    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

	    String result2 = mapper.writeValueAsString(date);
	    System.out.println("result2:"+result2);	
		System.out.println("--------------------------");	

	    Event2 event22 = new Event2("party", new Date(), date);

	    String result3 = mapper.writeValueAsString(event22);
	    System.out.println("result3:"+result3);	

	    

	}

}
