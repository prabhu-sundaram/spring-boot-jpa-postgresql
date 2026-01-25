package com.dm.springbootjpapostgresql.dto.deserializer;

import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.dm.springbootjpapostgresql.model.entity.TaxInvoice;

public class InvoiceDeserializer extends JsonDeserializer<TaxInvoice> {

	public InvoiceDeserializer() {
		super(TaxInvoice.class);
	}

}
