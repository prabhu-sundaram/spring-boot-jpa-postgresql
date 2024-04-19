package com.dm.springbootjpapostgresql.service;

import okhttp3.*; 

import java.io.IOException;

import org.springframework.stereotype.Service; 

@Service
public class ApiService { 

	private final OkHttpClient client = new OkHttpClient(); 
	
	// Get Request 
	public String makeGetRequest(String apiUrl) throws IOException { 
		Request request = new Request.Builder().url(apiUrl).build(); 

		try (Response response = client.newCall(request).execute()) { 
			if (response.isSuccessful()) { 
				return response.body().string(); 
			} else { 
				throw new IOException("Unexpected response: " + response.code()); 
			} 
		} 
	} 
	
	// Post Request 
	public String makePostRequest(String apiUrl, String requestBody) throws IOException { 
		RequestBody body = RequestBody.create(requestBody, MediaType.parse("application/json")); 
		Request request = new Request.Builder().url(apiUrl).post(body).build(); 

		try (Response response = client.newCall(request).execute()) { 
			if (response.isSuccessful()) { 
				return response.body().string(); 
			} else { 
				throw new IOException("Unexpected response: " + response.code()); 
			} 
		} 
	} 
} 

