package com.dm.springbootjpapostgresql.service.HttpClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HttpClientServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(HttpClientServiceTest.class);
    
	@Autowired
	HttpClientService httpClientService;

	@Test
	public void RestTest1() throws URISyntaxException{	
		httpClientService.invokeGetAsync();

	}

}