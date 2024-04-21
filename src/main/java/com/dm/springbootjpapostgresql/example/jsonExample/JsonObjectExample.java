package com.dm.springbootjpapostgresql.example.jsonExample;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import com.dm.springbootjpapostgresql.example.beans.Student;


public class JsonObjectExample {

	public static void main(String[] args) {


		System.out.println("---------------JSONObject-------------");
		System.out.println("--------------Creating JSON Directly from JSONObject--------------");
		JSONObject jo = new JSONObject();
		jo.put("id", 23);
		jo.put("active", false);
		jo.put("name", "prabhu");
		System.out.println("jo:"+jo);
		System.out.println("----------------------------");
		
		System.out.println("--------------Creating JSON from Map--------------");
		Map<String,String> hm = new HashMap<String,String>();
		hm.put("id", "342");
		hm.put("name", "prabhu");
		JSONObject jo2 = new JSONObject(hm);
		System.out.println("jo2:"+jo2);
		System.out.println("----------------------------");
		
		System.out.println("--------------Creating JSONObject from JSON String--------------");
		JSONObject jo3 = new JSONObject("{\"name\":\"prabhu3324234\",\"active\":true,\"id\":23423}");
		System.out.println("jo3:"+jo3);
		System.out.println("----------------------------");
		
		System.out.println("--------------Serialize Java Object to JSON--------------");
		Student s1 = new Student();
		s1.setAge(22);
		s1.setName("prabhu");
		s1.setRegistrationNumber("AC23423");
		System.out.println("s1:"+s1);
		System.out.println("s1:"+s1.toString());
		
		JSONObject jo4 = new JSONObject(s1);
		System.out.println("jo4:"+jo4);
		
		
	}

}
