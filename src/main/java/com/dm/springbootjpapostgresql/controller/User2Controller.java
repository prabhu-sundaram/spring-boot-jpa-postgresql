package com.dm.springbootjpapostgresql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dm.springbootjpapostgresql.model.Address2;
import com.dm.springbootjpapostgresql.model.Company2;
import com.dm.springbootjpapostgresql.model.Geo;
import com.dm.springbootjpapostgresql.model.User2;

@RestController
@RequestMapping("/api/users2")
public class User2Controller {
 
    //RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private RestTemplate restTemplate;

    //@Autowired
    //private RestTemplateBuilder restTemplateBuilder;
    
    
 @GetMapping("/{id}")
 @ResponseBody
 private String getUser(@PathVariable Integer id) {
  String uri = "https://jsonplaceholder.typicode.com/users/"+id;
  
  //RestTemplate restTemplate = restTemplateBuilder.build();

  
  User2 user = restTemplate.getForObject(uri, User2.class);
  System.out.println("User: " + user);
  
  System.out.println("Userid: " + user.getId());
  System.out.println("Name: " + user.getName());
  System.out.println("Username: " + user.getUsername());
  System.out.println("Email: " + user.getEmail());
  
  Address2 address = user.getAddress();
  System.out.println("Address: " 
    + address.getStreet() + ", " 
    + address.getCity() + ", "
    + address.getZipcode()
    );
  
  Geo geo = address.getGeo();
  System.out.println("Geo Lat: " 
    + geo.getLat() + ", Geo Lng: " 
    + geo.getLng() 
    );
  
  Company2 company = user.getCompany();
  System.out.println("Company: " 
    + company.getName() + ", " 
    + company.getCatchPhrase() + ", "
    + company.getBs()
    );
  return "User detail page.";
 }
}

