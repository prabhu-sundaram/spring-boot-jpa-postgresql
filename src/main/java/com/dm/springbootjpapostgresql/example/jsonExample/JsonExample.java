package com.dm.springbootjpapostgresql.example.jsonExample;

import org.json.CDL;
import org.json.Cookie;
import org.json.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonExample {

	public static void main(String[] args) {
		System.out.println("---------------JSONTokener-------------");
		JSONTokener jt = new JSONTokener("prabhu test test2");
		while(jt.more())
		{
			System.out.println(jt.next());
		}
		System.out.println("---------------CDL-------------");
		System.out.println("---------------Producing JSONArray Directly from Comma Delimited Text-------------");
		JSONArray ja1 = CDL.rowToJSONArray(new JSONTokener("England, USA, Canada"));
		System.out.println("ja1:"+ja1);
		
		System.out.println("---------------Producing Comma Delimited Text from JSONArray-------------");
		JSONArray ja3 = new JSONArray("[false,0,\"prabhu\"]");
		String cdt = CDL.rowToString(ja3);
		System.out.println("cdt:"+cdt);
		System.out.println("----------------------------");
		System.out.println("---------------Producing JSONArray of JSONObjects Using Comma Delimited Text-------------");
		String string = "name, city, age \n" +
				  "john, chicago, 22 \n" +
				  "gary, florida, 35 \n" +
				  "sal, vegas, 18";

				JSONArray result = CDL.toJSONArray(string);
				System.out.println("result"+result);

				JSONArray ja = new JSONArray();
				ja.put("name");
				ja.put("city");
				ja.put("age");

				String string2 = "john, chicago, 22 \n"
				  + "gary, florida, 35 \n"
				  + "sal, vegas, 18";

				JSONArray result2 = CDL.toJSONArray(ja, string2);
				System.out.println("result2:"+result2);
				
				System.out.println("---------------Cookie-------------");
				System.out.println("---------------Converting a Cookie String into a JSONObject-------------");
				String cookie = "username=John Doe; expires=Thu, 18 Dec 2013 12:00:00 UTC; path=/";
				JSONObject cookieJO = Cookie.toJSONObject(cookie);
				System.out.println("cookieJO:"+cookieJO);
				System.out.println("---------------Converting a JSONObject into Cookie String-------------");
				String cookie2 = Cookie.toString(cookieJO);
				System.out.println("cookie2:"+cookie2);

				
				System.out.println("---------------HTTP-------------");
				System.out.println("---------------Converting JSONObject to HTTP Header-------------");
				JSONObject jo = new JSONObject();
				jo.put("Method", "POST");
				jo.put("Request-URI", "http://www.example.com/");
				jo.put("HTTP-Version", "HTTP/1.1");
				String httpStr = HTTP.toString(jo);
				System.out.println("httpStr:"+httpStr);
				
				System.out.println("---------------Converting HTTP Header String Back to JSONObject-------------");
				JSONObject obj = HTTP.toJSONObject("POST \"http://www.example.com/\" HTTP/1.1");
				System.out.println("obj:"+obj);
				
	}

}
