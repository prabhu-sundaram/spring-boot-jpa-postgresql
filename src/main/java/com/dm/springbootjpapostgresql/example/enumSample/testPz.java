package com.dm.springbootjpapostgresql.example.enumSample;

import com.dm.springbootjpapostgresql.example.beans.Pizza;

public class testPz {

	public static void main(String[] args) {
		System.out.println(PizzaStatus.DELIVERED);
		System.out.println(Pizza.PizzaStatus.ORDERED);

		Pizza testPz=new Pizza();
	    testPz.setStatus(Pizza.PizzaStatus.READY);
		
		if(testPz.getStatus().equals(Pizza.PizzaStatus.DELIVERED)) 
			System.out.println("delivered"); 
		else 
			System.out.println("not delivered");
		
		if(testPz.getStatus() == Pizza.PizzaStatus.DELIVERED) 
		System.out.println("delivered2"); 
		else 
		System.out.println("not delivered2");		
		
		/*
		 * if(testPz.getStatus().equals(TestColor.GREEN)); if(testPz.getStatus() ==
		 * TestColor.GREEN);
		 */
		
		if(testPz.getStatus() == Pizza.PizzaStatus.READY) 
		System.out.println("ready for deliverable"); 
		else 
		System.out.println("not yet ready");			

		if(testPz.isDeliverable()) 
		System.out.println("ready for deliverable"); 
		else 
		System.out.println("not yet ready");	
		
		System.out.println("Delivery time:"+testPz.getDeliveryTimeInDays());
		
	}
	

}
