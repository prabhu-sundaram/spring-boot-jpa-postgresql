package com.dm.springbootjpapostgresql.dto.deserializer;

import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.dm.springbootjpapostgresql.model.entity.Shipment;

public class ShipmentDeserializer extends JsonDeserializer<Shipment> {

	public ShipmentDeserializer() {
		super(Shipment.class);
	}

}
