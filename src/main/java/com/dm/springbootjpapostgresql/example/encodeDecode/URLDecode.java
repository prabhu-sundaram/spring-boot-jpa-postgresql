package com.dm.springbootjpapostgresql.example.encodeDecode;

//import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Collectors;

//import org.junit.Test;

public class URLDecode {


	private String decode(String value) {
	    try {
			return URLDecoder.decode(value, StandardCharsets.UTF_8.toString());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}


	//@Test
	public void givenRequestParam_whenUTF8Scheme_thenDecodeRequestParams() throws URISyntaxException {
		String testUrl = "http://www.baeldung.com?key1=value+1&key2=value%40%21%242&key3=value%253";		
		
	    URI uri = new URI(testUrl);

	    String scheme = uri.getScheme();
	    String host = uri.getHost();
	    String query = uri.getRawQuery();

	    String decodedQuery = Arrays.stream(query.split("&"))
	      .map(param -> param.split("=")[0] + "=" + decode(param.split("=")[1]))
	      .collect(Collectors.joining("&"));

	    System.out.println(scheme);
	    System.out.println(host);
	    System.out.println(query);
	    System.out.println(decodedQuery);
	    
	    //assertEquals(
	   //   "http://www.baeldung.com?key1=value 1&key2=value@!$2&key3=value%3",
	   //   scheme + "://" + host + "?" + decodedQuery);
	}
	
}
