package com.dm.springbootjpapostgresql.example.jacksonExample;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.dm.springbootjpapostgresql.example.beans.Car;
import com.dm.springbootjpapostgresql.example.beans.Car2;

public class ConfigureSerDeser {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		String jsonString = "{ \"color\" : \"Black\", \"type\" : \"Fiat\", \"year\" : \"1970\" }";
		ObjectMapper objectMapper = new ObjectMapper();
		
		//objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Car car = objectMapper.readValue(jsonString, Car.class);
		System.out.println("car:"+car);
		
		System.out.println("-------------------");
		
		JsonNode jsonNodeRoot = objectMapper.readTree(jsonString);
		System.out.println("jsonNodeRoot:"+jsonNodeRoot);
		
		JsonNode jsonNodeYear = jsonNodeRoot.get("year");
		System.out.println("jsonNodeYear:"+jsonNodeYear);
		String year = jsonNodeYear.asText();
		System.out.println("year:"+year);
		
		
		JsonNode jsonNodeEngine = jsonNodeRoot.get("engine");
		System.out.println("jsonNodeEngine:"+jsonNodeEngine);
		
		//NullPointerException
		//String engine = jsonNodeEngine.asText();
		//System.out.println("engine:"+engine);		
		System.out.println("-------------------");

		//objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		String jsonString2 = "{ \"color\" : \"Black\", \"type\" : null, \"year\" : \"1970\" }";
		Car car3 = objectMapper.readValue(jsonString2, Car.class);
		System.out.println("car3:"+car3);
		System.out.println("-------------------");
		
		objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
		//objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true); //this is for int,boolean
		String carJson2 = "{ \"brand\":\"Toyota\", \"status\":null }";
		Car2 car25 = objectMapper.readValue(carJson2,Car2.class);
		System.out.println("car25:"+car25);
		
		String carJson = "{ \"brand\":\"Toyota\", \"doors\":null }";

		Car2 car22 = objectMapper.readValue(carJson, Car2.class);
		System.out.println("car22:"+car22);
		System.out.println("-------------------");		
		objectMapper.configure(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS, false);

		
		
	}

}
