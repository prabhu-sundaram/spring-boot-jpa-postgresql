package com.dm.springbootjpapostgresql.dto;

public record UserOrder(String orderId, String productName, int quantity) {}
