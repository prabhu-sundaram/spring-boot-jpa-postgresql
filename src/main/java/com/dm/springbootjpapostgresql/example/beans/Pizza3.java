package com.dm.springbootjpapostgresql.example.beans;

//import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

//import org.junit.Test;

public class Pizza3 {

	/*
	 * private static EnumSet<PizzaStatus> undeliveredPizzaStatuses =
	 * EnumSet.of(PizzaStatus.ORDERED, PizzaStatus.READY);
	 * 
	 * private PizzaStatus status;
	 * 
	 * // Methods that set and get the status variable.
	 * 
	 * public PizzaStatus getStatus() { return status; }
	 * 
	 * public void setStatus(PizzaStatus status) { this.status = status; }
	 * 
	 * public enum PizzaStatus { ORDERED (5){
	 * 
	 * @Override public boolean isOrdered() { return true; } }, READY (2){
	 * 
	 * @Override public boolean isReady() { return true; } }, DELIVERED (0){
	 * 
	 * @Override public boolean isDelivered() { return true; } };
	 * 
	 * 
	 * public boolean isDeliverable() { return this.status.isReady(); }
	 * 
	 * public void printTimeToDeliver() { System.out.println("Time to delivery is "
	 * + this.getStatus().getTimeToDelivery() + " days"); }
	 * 
	 * public static List<Pizza> getAllUndeliveredPizzas(List<Pizza> input) { return
	 * input.stream().filter( (s) ->
	 * undeliveredPizzaStatuses.contains(s.getStatus()))
	 * .collect(Collectors.toList()); }
	 * 
	 * 
	 * 
	 * public void deliver() { if (isDeliverable()) {
	 * PizzaDeliverySystemConfiguration.getInstance().getDeliveryStrategy()
	 * .deliver(this); this.setStatus(PizzaStatus.DELIVERED); } }
	 * 
	 * 
	 * //@Test public void
	 * givenPizaOrders_whenRetrievingUnDeliveredPzs_thenCorrectlyRetrieved() {
	 * List<Pizza> pzList = new ArrayList<>();
	 * 
	 * Pizza pz1 = new Pizza(); pz1.setStatus(Pizza.PizzaStatus.DELIVERED);
	 * 
	 * Pizza pz2 = new Pizza(); pz2.setStatus(Pizza.PizzaStatus.ORDERED);
	 * 
	 * Pizza pz3 = new Pizza(); pz3.setStatus(Pizza.PizzaStatus.ORDERED);
	 * 
	 * Pizza pz4 = new Pizza(); pz4.setStatus(Pizza.PizzaStatus.READY);
	 * 
	 * pzList.add(pz1); pzList.add(pz2); pzList.add(pz3); pzList.add(pz4);
	 * 
	 * List<Pizza> undeliveredPzs = Pizza.getAllUndeliveredPizzas(pzList);
	 * assertTrue(undeliveredPzs.size() == 3); }
	 */
}