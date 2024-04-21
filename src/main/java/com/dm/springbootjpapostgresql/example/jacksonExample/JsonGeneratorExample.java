package com.dm.springbootjpapostgresql.example.jacksonExample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.dm.springbootjpapostgresql.example.beans.Emp;

public class JsonGeneratorExample {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		JsonFactory factory = new JsonFactory();

		JsonGenerator generator = factory.createGenerator(
		    new File("src/main/resources/example/outputJSONGen.json"), JsonEncoding.UTF8);

		generator.writeStartObject();
		generator.writeStringField("brand", "Mercedes");
		generator.writeNumberField("doors", 5);
		generator.writeEndObject();

		generator.close();		
		System.out.println("--------------------------");	
		
		Emp emp = JacksonWriteExample.createEmployee();

		JsonGenerator jsonGenerator = new JsonFactory()
				.createGenerator(new FileOutputStream("src/main/resources/example/stream_emp.txt"));
		//for pretty printing
		jsonGenerator.setPrettyPrinter(new DefaultPrettyPrinter());
		
		jsonGenerator.writeStartObject(); // start root object
		jsonGenerator.writeNumberField("id", emp.getId());
		jsonGenerator.writeStringField("name", emp.getName());
		jsonGenerator.writeBooleanField("permanent", emp.isPermanent());
		
		jsonGenerator.writeObjectFieldStart("address"); //start address object
			jsonGenerator.writeStringField("street", emp.getAddress().getStreet());
			jsonGenerator.writeStringField("city", emp.getAddress().getCity());
			jsonGenerator.writeNumberField("zipcode", emp.getAddress().getZipcode());
		jsonGenerator.writeEndObject(); //end address object
		
		jsonGenerator.writeArrayFieldStart("phoneNumbers");
			for(long num : emp.getPhoneNumbers())
				jsonGenerator.writeNumber(num);
		jsonGenerator.writeEndArray();
		
		jsonGenerator.writeStringField("role", emp.getRole());
		
		jsonGenerator.writeArrayFieldStart("cities"); //start cities array
		for(String city : emp.getCities())
			jsonGenerator.writeString(city);
		jsonGenerator.writeEndArray(); //closing cities array
		
		jsonGenerator.writeObjectFieldStart("properties");
			Set<String> keySet = emp.getProperties().keySet();
			for(String key : keySet){
				String value = emp.getProperties().get(key);
				jsonGenerator.writeStringField(key, value);
			}
		jsonGenerator.writeEndObject(); //closing properties
		jsonGenerator.writeEndObject(); //closing root object
		
		jsonGenerator.flush();
		jsonGenerator.close();

	}

}
