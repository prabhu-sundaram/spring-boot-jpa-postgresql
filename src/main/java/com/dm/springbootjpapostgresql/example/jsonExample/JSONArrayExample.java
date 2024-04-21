package com.dm.springbootjpapostgresql.example.jsonExample;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONArrayExample {

	public static void main(String[] args) {
		System.out.println("---------------JSONArray-------------");
		System.out.println("--------------Creating JSONArray--------------");
		
		JSONArray ja = new JSONArray();
		ja.put(false);
		ja.put(0);
		ja.put("prabhu");
		System.out.println("ja:"+ja);
		System.out.println("----------------------------");
		
		JSONArray ja2 = new JSONArray();
		ja2.put(false);
		ja2.put(34343);
		JSONObject jo = new JSONObject();
		jo.put("id", 23);
		jo.put("active", false);
		jo.put("name", "prabhu");
		ja.put(jo);
		System.out.println("ja:"+ja);
		ja2.put(jo);
		System.out.println("ja2:"+ja2);			
		System.out.println("----------------------------");
		
		System.out.println("--------------Creating JSONArray Directly from JSON String--------------");
		JSONArray ja3 = new JSONArray("[false,0,\"prabhu\"]");
		System.out.println("ja3:"+ja3);	
		JSONArray ja4 = new JSONArray("[false,34343,{\"name\":\"prabhu\",\"active\":false,\"id\":23}]");
		System.out.println("ja4:"+ja4);	
		System.out.println("----------------------------");
		
		System.out.println("--------------Creating JSONArray Directly from a Collection or an Array--------------");
		List<String> al = new ArrayList<String>();
		al.add("prabhu");
		al.add("test");
		System.out.println("al:"+al);
		JSONArray ja5 = new JSONArray();
		ja5.put(al);
		System.out.println("ja5:"+ja5);
		JSONArray ja6 = new JSONArray(al);
		System.out.println("ja6:"+ja6);
		
		System.out.println("----------------------------");
		
		
	}

}
