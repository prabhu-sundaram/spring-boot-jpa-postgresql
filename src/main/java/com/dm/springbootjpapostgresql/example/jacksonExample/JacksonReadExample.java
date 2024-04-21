package com.dm.springbootjpapostgresql.example.jacksonExample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.json.JSONString;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.dm.springbootjpapostgresql.example.beans.Car;
import com.dm.springbootjpapostgresql.example.beans.Emp;
import com.dm.springbootjpapostgresql.example.beans.Staff;

public class JacksonReadExample {

	public static void main(String[] args) throws IOException {
		//create ObjectMapper instance

		ObjectMapper om = new ObjectMapper();
	
		System.out.println("------------Read Object From JSON String--------------");
		
		Car car1 = om.readValue("{\"color\":\"yellow\",\"type\":\"renault\"}", Car.class);
		System.out.println("car1:"+car1.toString());

		System.out.println("------------Read Object From JSON File--------------");
		
		Car car2 = om.readValue(new File("src/main/resources/example/car.json"), Car.class);
		System.out.println("car2:"+car2.toString());
		
		Staff s3 = new Staff();
		s3 = om.readValue(new File("src/main/resources/example/staff.json"), Staff.class);
		System.out.println("s3:"+s3);
		
		//read json file data to byte array
		byte[] jsonData = Files.readAllBytes(Paths.get("src/main/resources/example/employee.txt"));
		
		//convert byte array to object
		Emp emp = om.readValue(jsonData, Emp.class);
		
		System.out.println("Employee Object\n"+emp);
		
		System.out.println("------------Read Object From JSON via URL--------------");

		Car car22 = om.readValue(new URL("file:src/main/resources/example/car.json"), Car.class);
		System.out.println("car22:"+car22.toString());	
		
		System.out.println("------------Read Object From JSON Reader--------------");
		String s34 = new String("{\"color\":\"yellow\",\"type\":\"renault\"}");
		Reader r = new StringReader(s34);
		Car car34 = om.readValue(r, Car.class);
		System.out.println("car34:"+car34.toString());	
		
		System.out.println("------------Read Object From JSON InputStream--------------");
		InputStream is = new FileInputStream("src/main/resources/example/staff45.json");
		Staff st45 = om.readValue(is, Staff.class);
		System.out.println("st45:"+st45.toString());	
		
		
		System.out.println("------------Read Object From JSON Byte Array--------------");
		String s35 = new String("{\"color\":\"yellow\",\"type\":\"renault\"}");
		byte[] ba = s35.getBytes();
		Car car35 = om.readValue(ba, Car.class);
		System.out.println("car35:"+car35.toString());	
		
		System.out.println("------------Read Object Array From JSON Array String--------------");
		String s36 = new String("[{\"color\":\"yellow\",\"type\":\"renault\"},{\"color\":\"green\",\"type\":\"maruthi\"}]");
		Car[] cars = om.readValue(s36, Car[].class);

		String jsonCarArray = 
				  "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
		Car[] cars3 = objectMapper.readValue(jsonCarArray, Car[].class);
		// print cars
		
		System.out.println("------------Read Object List From JSON Array String--------------");
		String s37 = new String("[{\"color\":\"yellow\",\"type\":\"renault\"},{\"color\":\"green\",\"type\":\"maruthi\"}]");
		List<Car> cars2 = om.readValue(s37, new TypeReference<List<Car>>(){});
		
		ObjectMapper objectMapper2 = new ObjectMapper();
		List<Car> listCar = objectMapper2.readValue(jsonCarArray, new TypeReference<List<Car>>(){});
		// print cars
		
		System.out.println("------------Read Map from JSON String--------------");
		String s38 = new String("{\"color\":\"green\",\"type\":\"maruthi\"}");
		Map<String,Object> carMap = om.readValue(s38, HashMap.class);
		System.out.println("carMap: "+carMap);
		
		byte[] mapData = Files.readAllBytes(Paths.get("src/main/resources/example/data.txt"));
		Map<String,String> myMap = new HashMap<String, String>();
		myMap = om.readValue(mapData, HashMap.class);
		System.out.println("myMap: "+myMap);
		
		//another way
		Map<String,Object> carMap2 = om.readValue(s38, new TypeReference<HashMap<String,Object>>(){});	
		System.out.println("Map using TypeReference: "+carMap2);		
	
		myMap = objectMapper.readValue(mapData, new TypeReference<HashMap<String,String>>() {});
		System.out.println("Map using TypeReference: "+myMap);		

		System.out.println("--------JSON2JacksonJsonNode----readTree--------------");

		String json = "{ \"color\" : \"Black\", \"type\" : \"FIAT\" }";
		JsonNode jsonNode = om.readTree(json);
		String color = jsonNode.get("color").asText();
		// Output: color -> Black
		System.out.println("color:"+color);

		System.out.println("-------------readTree-------------");
		
		//read JSON like DOM Parser
		JsonNode rootNode = om.readTree(jsonData);
		JsonNode idNode = rootNode.path("id");
		System.out.println("id = "+idNode.asInt());

		JsonNode phoneNosNode = rootNode.path("phoneNumbers");
		Iterator<JsonNode> elements = phoneNosNode.elements();
		while(elements.hasNext()){
			JsonNode phone = elements.next();
			System.out.println("Phone No = "+phone.asLong());
		}
		System.out.println("--------------------------");
		System.out.println("-------------readTree-------------");

	    String jsonString = "{\"k1\":\"v1\",\"k2\":\"v2\"}";

	    JsonNode actualObj2 = om.readTree(jsonString);	    
	    JsonNode jsonNode1 = actualObj2.get("k1");
		System.out.println("jsonNode1:"+jsonNode1);
		System.out.println("jsonNode1:"+jsonNode1.asText());
		
	    JsonFactory factory = om.getFactory();
	    JsonParser parser = factory.createParser(jsonString);
	    JsonNode actualObj = om.readTree(parser);
		System.out.println("actualObj:"+actualObj);
		System.out.println("actualObj:"+actualObj.asText());	    
	
		System.out.println("--------------------------");
		

	}

	

	
}
