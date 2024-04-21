package com.dm.springbootjpapostgresql.example.jacksonExample;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.dm.springbootjpapostgresql.example.beans.*;
//import com.dm.springbootjpapostgresql.example.jacksonExample.Employee;


public class JacksonWriteExample2 {

	public static void main(String[] args) throws JsonProcessingException {
		
		Employee e = new Employee(1,"prabhu",34,50000);
		System.out.println(e.getId());
		System.out.println(e.getName());
		System.out.println(e.getAge());
		System.out.println(e.getSalary());
		System.out.println(e);
		System.out.println(e.toString());
		System.out.println("-------------------------");
		
		Employee e2 = new Employee();
		System.out.println(e2.getId());
		System.out.println(e2.getName());
		System.out.println(e2.getAge());
		System.out.println(e2.getSalary());		
		System.out.println(e2);
		System.out.println(e2.toString());
		System.out.println("-------------------------");
		
		Student s = new Student();
		s.setName("prabhu");
		s.setAge(24);
		s.setRegistrationNumber("ABC12323");
		System.out.println(s.toString());
		System.out.println("-------------------------");
		
		Employee e3 = new Employee();
		e3.setId(33);
		e3.setName("prabhu2");
		e3.setAge(22);
		e3.setSalary(3434);
		
		System.out.println(e3.toString());
		System.out.println("-------------------------");		
			
		List<Integer> pincodes = new ArrayList<Integer>(); 
		pincodes.add(123);
		pincodes.add(343);
		pincodes.add(531);
		
		List<String> banks = new ArrayList<String>(); 
		banks.add("SBI");
		banks.add("HDFC");
		banks.add("SIB");
		
		e3.setPincodes(pincodes);
		e3.setBanks(banks);
		System.out.println(e3.toString());
		System.out.println("-------------------------");	
		
		Order o1 = new Order();
		o1.setOrderId(12);
		o1.setOrderDesc("desc");
		o1.setOrderAmount(43242.34344);
		o1.setOrderStatus("open");
		System.out.println(o1.toString());
		
		Order o2 = new Order();
		o2.setOrderId(54);
		o2.setOrderDesc("desc2222");
		o2.setOrderAmount(23.3);
		o2.setOrderStatus("closed");
		System.out.println(o1.toString());		
		System.out.println("-------------------------");
		
		List<Order> orders = new LinkedList<Order>();
		orders.add(o1);
		orders.add(o2);
		e3.setOrder(orders);
		System.out.println(e3.toString());
		System.out.println("-------------------------");
		
		ObjectMapper objectMapper = new ObjectMapper();
		String e3Payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(e3);
		System.out.println(e3Payload);		
		
	}

}
