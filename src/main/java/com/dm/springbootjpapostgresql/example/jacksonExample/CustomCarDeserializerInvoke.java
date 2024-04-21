package com.dm.springbootjpapostgresql.example.jacksonExample;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.dm.springbootjpapostgresql.example.beans.Car;

public class CustomCarDeserializerInvoke {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
		ObjectMapper mapper = new ObjectMapper();
		SimpleModule module =
		  new SimpleModule("CustomCarDeserializer", new Version(1, 0, 0, null, null, null));
		module.addDeserializer(Car.class, new CustomCarDeserializer());
		mapper.registerModule(module);
		Car car = mapper.readValue(json, Car.class);
		System.out.println("car:"+car);

	}

}
