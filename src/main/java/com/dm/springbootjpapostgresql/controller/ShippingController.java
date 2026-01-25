package com.dm.springbootjpapostgresql.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.springbootjpapostgresql.model.entity.Shipment;
import com.dm.springbootjpapostgresql.repository.jpa.ShipmentRepository;

@RestController
@RequestMapping("/api/shipment")
public class ShippingController {

    private final ShipmentRepository shipmentRepository;

    public ShippingController(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    // Returns a single shipment or 404 if not found
    @GetMapping("/{id}")
    public ResponseEntity<Shipment> getShipment(@PathVariable("id") Long id) {
        return shipmentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Returns a list of all shipments
    @GetMapping
    public ResponseEntity<Iterable<Shipment>> getAllShipments() {
        Iterable<Shipment> shipments = shipmentRepository.findAll();
        return ResponseEntity.ok(shipments);
    }
}