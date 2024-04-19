package com.dm.springbootjpapostgresql.controller;

import okhttp3.*; 

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.springbootjpapostgresql.service.ApiService;

@RestController
@RequestMapping("/api/rest") 
public class ApiController { 

	@Autowired
	private ApiService apiService; 

	// End-point for GET Request 
	@GetMapping("/get-example") 
	public String getExample() { 
		String apiUrl = "https://jsonplaceholder.typicode.com/posts/1"; 

		try { 
			String apiResponse = apiService.makeGetRequest(apiUrl); 
			return "GET Response: " + apiResponse; 
		} catch (IOException e) { 
			e.printStackTrace(); 
			return "While making GET request, getting Error: " + e.getMessage(); 
		} 
	} 

	// End-point for POST Request 
	@PostMapping("/post-example") 
	public String postExample() { 
		String apiUrl = "https://jsonplaceholder.typicode.com/posts"; 
		
		// This is the request body 
		String requestBody = "{\'title\': \'foo\',\'body\': \'bar\',\'userId\': 1}"; 

		try { 
			String apiResponse = apiService.makePostRequest(apiUrl, requestBody); 
			return "POST Response: " + apiResponse; 
		} catch (IOException e) { 
			e.printStackTrace(); 
			return "While making POST request, getting Error: " + e.getMessage(); 
		} 
	} 
}

