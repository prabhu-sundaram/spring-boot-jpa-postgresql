package com.dm.springbootjpapostgresql.example.jacksonExample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.dm.springbootjpapostgresql.example.beans.Car;

public class CustomCarSerializerInvoke {

	public static void main(String[] args) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		SimpleModule module = 
		  new SimpleModule("CustomCarSerializer", new Version(1, 0, 0, null, null, null));
		module.addSerializer(Car.class, new CustomCarSerializer());
		mapper.registerModule(module);
		Car car = new Car("yellow", "renault");
		String carJson = mapper.writeValueAsString(car);
		System.out.println("carJson:"+carJson);

	}

}
