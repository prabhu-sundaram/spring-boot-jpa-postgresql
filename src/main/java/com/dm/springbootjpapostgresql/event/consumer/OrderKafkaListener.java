package com.dm.springbootjpapostgresql.event.consumer;

import org.springframework.kafka.support.Acknowledgment;

import com.dm.springbootjpapostgresql.model.entity.Shipment;
import com.dm.springbootjpapostgresql.model.entity.TaxInvoice;

public interface OrderKafkaListener {

	public void order(Shipment shipment, Acknowledgment acknowledgment);
	public void order(TaxInvoice invoice, Acknowledgment acknowledgment);
	
}
