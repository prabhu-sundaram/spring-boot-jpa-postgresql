package com.dm.springbootjpapostgresql.event.consumer.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.dm.springbootjpapostgresql.event.consumer.OrderKafkaListener;
import com.dm.springbootjpapostgresql.model.entity.Shipment;
import com.dm.springbootjpapostgresql.model.entity.TaxInvoice;

import com.dm.springbootjpapostgresql.service.ShipmentService;
import com.dm.springbootjpapostgresql.service.TaxInvoiceService;


@Component
public class OrderKafkaListenerImpl implements OrderKafkaListener {

	private final Logger log = LoggerFactory.getLogger(OrderKafkaListenerImpl.class);

	private ShipmentService shipmentService;
	private TaxInvoiceService invoiceService;

	public OrderKafkaListenerImpl(ShipmentService shipmentService,TaxInvoiceService invoiceService) {
		super();
		this.shipmentService = shipmentService;
		this.invoiceService = invoiceService;
	}

	//@KafkaListener(topics = "order")
	@KafkaListener(topics = "order", containerFactory = "shippingFactory")
	public void order(Shipment shipment, Acknowledgment acknowledgment) {
		log.info("Received shipment " + shipment.getId());
		shipmentService.ship(shipment);
		acknowledgment.acknowledge();
	}
	
	//@KafkaListener(topics = "order")
	@KafkaListener(topics = "order", containerFactory = "invoicingFactory")	
	public void order(TaxInvoice invoice, Acknowledgment acknowledgment) {
		log.info("Received invoice " + invoice.getId());
		invoiceService.generateInvoice(invoice);
		acknowledgment.acknowledge();
	}
	
}
