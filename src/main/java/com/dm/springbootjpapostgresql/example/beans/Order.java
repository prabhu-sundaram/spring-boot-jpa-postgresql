package com.dm.springbootjpapostgresql.example.beans;

public class Order {
private int orderId;
private String orderDesc;
private double orderAmount;
private String orderStatus;
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public String getOrderDesc() {
	return orderDesc;
}
public void setOrderDesc(String orderDesc) {
	this.orderDesc = orderDesc;
}
public double getOrderAmount() {
	return orderAmount;
}
public void setOrderAmount(double orderAmount) {
	this.orderAmount = orderAmount;
}
public String getOrderStatus() {
	return orderStatus;
}
public void setOrderStatus(String orderStatus) {
	this.orderStatus = orderStatus;
}
@Override
public String toString() {
	return "Order [orderId=" + orderId + ", orderDesc=" + orderDesc + ", orderAmount=" + orderAmount + ", orderStatus="
			+ orderStatus + "]";
}


}
