package com.dm.springbootjpapostgresql.event.producer;

import com.dm.springbootjpapostgresql.model.entity.Order;

public interface OrderKafkaService {

	public Order order(Order order);
	public double getPrice(long orderId);

}
