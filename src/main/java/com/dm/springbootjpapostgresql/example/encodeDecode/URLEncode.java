package com.dm.springbootjpapostgresql.example.encodeDecode;

//import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//import org.junit.Test;
import org.springframework.web.util.UriUtils;

public class URLEncode {

	public static void main(String[] args) throws Exception {
	
		URLEncode u1 =new URLEncode();
		
		System.out.println(u1.extractURIDetails("http://www.baeldung.com?key1=value+1&key2=value%40%21%242&key3=value%253"));
		System.out.println("---------------------------------Encode the URL");

		System.out.println(u1.encodeValue("http://www.baeldung.com?key1=value+1&key2=value%40%21%242&key3=value%253"));
		
		u1.givenRequestParam_whenUTF8Scheme_thenEncode();
		System.out.println("---------------------------------Encode a Path Segment");

		System.out.println(u1.encodePath("/Path 1/Path+2"));
	}
	
	

public String extractURIDetails(String testUrl) throws URISyntaxException{
	//Analyze the URL
	//testUrl = "http://www.baeldung.com?key1=value+1&key2=value%40%21%242&key3=value%253";		

	URI uri = new URI(testUrl);

	System.out.println(uri.getScheme());
	System.out.println(uri.getHost());
	System.out.println(uri.getRawQuery());	
	
	return "success";
}

//---------------------------------------------------------Encode the URL
			private String encodeValue(String value) {
			    try {
					return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return value;
			}

			public void givenRequestParam_whenUTF8Scheme_thenEncode() throws Exception {
			    Map<String, String> requestParams = new HashMap<>();
			    requestParams.put("key1", "value 1");
			    requestParams.put("key2", "value@!$2");
			    requestParams.put("key3", "value%3");

			    String encodedURL = requestParams.keySet().stream()
			      .map(key -> key + "=" + encodeValue(requestParams.get(key)))
			      .collect(Collectors.joining("&", "http://www.baeldung.com?", ""));

			    System.out.println("encodedURL:"+encodedURL);
			    
			    String testUrl
			    = "/path+1?key1=value+1&key2=value%40%21%242&key3=value%253";
			    String path = "path+1";

			    String encodedURL2 = requestParams.keySet().stream()
			    		  .map(k -> k + "=" + encodeValue(requestParams.get(k)))
			    		  .collect(Collectors.joining("&", "/" + encodePath(path) + "?", ""));
			    
			    System.out.println("encodedURL2:"+encodedURL2);
			    
		    
		}
			
	//---------------------------------------------------------Encode a Path Segment
	private String encodePath(String path) throws UnsupportedEncodingException {
		path = UriUtils.encodePath(path, "UTF-8");
		return path;
	}
	  
	//@Test
	public void givenPathSegment_thenEncodeDecode() throws UnsupportedEncodingException {
		String pathSegment = "/Path 1/Path+2";
		String encodedPathSegment = encodePath(pathSegment);
		String decodedPathSegment = UriUtils.decode(encodedPathSegment, "UTF-8");
	  
	  //assertEquals("/Path%201/Path+2", encodedPathSegment);
	  //assertEquals("/Path 1/Path+2", decodedPathSegment); 
		}
	 

			
}
