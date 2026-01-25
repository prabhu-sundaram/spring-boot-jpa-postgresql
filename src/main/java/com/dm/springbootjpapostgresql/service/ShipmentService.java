package com.dm.springbootjpapostgresql.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dm.springbootjpapostgresql.model.entity.Shipment;
import com.dm.springbootjpapostgresql.repository.jpa.ShipmentRepository;

@Service
public class ShipmentService {

	private final Logger log = LoggerFactory.getLogger(ShipmentService.class);

	private ShipmentRepository shipmentRepository;

	public ShipmentService(ShipmentRepository shipmentRepository) {
		super();
		this.shipmentRepository = shipmentRepository;
	}

	@Transactional
	public void ship(Shipment shipment) {
		if (shipmentRepository.existsById(shipment.getId())) {
			log.info("Shipment id {} already exists - ignored", shipment.getId());
		} else {
			shipmentRepository.save(shipment);
		}
	}

}
