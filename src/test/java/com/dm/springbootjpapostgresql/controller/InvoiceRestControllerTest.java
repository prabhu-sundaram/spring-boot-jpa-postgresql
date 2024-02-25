package com.dm.springbootjpapostgresql.controller;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.dm.springbootjpapostgresql.model.Invoice;

@SpringBootTest
public class InvoiceRestControllerTest {

	private Logger logger = LoggerFactory.getLogger(InvoiceRestControllerTest.class);
	
	@Autowired
	RestTemplate restTemplate;
        
    @Test
	private void saveInv() {
		System.out.println("test");
		// 1. Producer application URL
		String url = "http://localhost:8080/api/invoices";
		// Send JSON data as Body
		String body = "{\"name\":\"INV11\", \"amount\":234.11,\"number\":\"INVOICE11\",\"receivedDate\":\"28-10-2020\",\"type\":\"Normal\",\"vendor\":\"ADHR001\",\"comments\" :\"On Hold\"}";
		// Http Header 
		HttpHeaders	headers = new HttpHeaders();
		//Set Content Type
		headers.setContentType(MediaType.APPLICATION_JSON);
		//requestEntity : Body+Header
		HttpEntity<String> request = new HttpEntity<String> (body,headers);
		// 2. make HTTP call and store Response (URL,ResponseType)
	//	ResponseEntity<String> response =  restTemplate.postForEntity(url, request, String.class);
		ResponseEntity<String> response =  restTemplate.exchange(url, HttpMethod.POST,request, String.class);
		// 3. Print details(body,status..etc)
		logger.info("Response Body : {}", response.getBody());
		logger.info("Status code value : {}", response.getStatusCodeValue());
		logger.info("Status code : {}", response.getStatusCode());
        logger.info("Status code : {}", response.getStatusCode().toString());

	}
	
    @Test
	private void getAllInvoices() {
		System.out.println("test");
		String url = "http://localhost:8080/api/invoices";
	    ResponseEntity<Invoice[]> response = restTemplate.getForEntity(url,Invoice[].class);
	//	ResponseEntity<Invoice[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Invoice[].class);
		Invoice[] invs = response.getBody();
		List<Invoice> list = Arrays.asList(invs);

		logger.info("Response Body : {}", list);
		logger.info("Status code value : {}", response.getStatusCodeValue());
		logger.info("Status code : {}", response.getStatusCode());
        logger.info("Status code : {}", response.getStatusCode().toString());
		logger.info("Headers {} :", response.getHeaders());
	}

    @Test
	private void getOneInvoice() {
		String url = "http://localhost:8080/api/invoices/{id}";
	//	ResponseEntity<String> response= restTemplate.getForEntity(url, String.class, 9);
		ResponseEntity<String> response= restTemplate.exchange(url, HttpMethod.GET, null, String.class, 7);
		logger.info("Response Body : {}", response.getBody());
		logger.info("Status code value : {}", response.getStatusCodeValue());
		logger.info("Status code : {}", response.getStatusCode());
        logger.info("Status code : {}", response.getStatusCode().toString());
	}
	
    @Test
	private void updateInvoice() {
		String url = "http://localhost:8080/api/invoices/{id}";
		String body = "{\"name\":\"INV13\",\"amount\":888}";
		// Request Header
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		// requestEntity = Body + header
		HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
	//	restTemplate.put(url, requestEntity, 7);
		ResponseEntity<String> response= restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class, 7);
		logger.info("Response Body : {}", response.getBody());
		logger.info("Status code value : {}", response.getStatusCodeValue());
		logger.info("Status code : {}", response.getStatusCode());
        logger.info("Status code : {}", response.getStatusCode().toString());
		logger.info("Response Headers : {}", response.getHeaders());
	}
	
    @Test
	private void deleteInvoice() {
		String url = "http://localhost:8080/api/invoices/{id}";
	//	restTemplate.delete(url, 6);
		ResponseEntity<String> response= restTemplate.exchange(url, HttpMethod.DELETE, null, String.class,5);
		logger.info("Response Body : {}", response.getBody());
		logger.info("Status code value : {}", response.getStatusCodeValue());
		logger.info("Status code : {}", response.getStatusCode());
        logger.info("Status code : {}", response.getStatusCode().toString());
		logger.info("Response Headers : {}", response.getHeaders());
	}
    
}
