package com.dm.springbootjpapostgresql.example.jacksonExample;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.dm.springbootjpapostgresql.example.beans.Event;

public class JacksonReadDateExample {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
	    String json = "{\"name\":\"party\",\"eventDate\":\"20-12-2014 02:30:00\"}";

	    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.setDateFormat(df);

	    Event event = mapper.readerFor(Event.class).readValue(json);
	    System.out.println("eventDate:"+df.format(event.getEventDate()));	

		System.out.println("--------------------------");	

	    String stringDate = "\"2014-12-20\"";

	    ObjectMapper mapper2 = new ObjectMapper();
	    mapper2.registerModule(new JavaTimeModule());
	    mapper2.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

	    LocalDate result2 = mapper2.readValue(stringDate, LocalDate.class);
	    System.out.println("result2:"+result2.toString());	
		System.out.println("--------------------------");	

	 
	    
	}

}
