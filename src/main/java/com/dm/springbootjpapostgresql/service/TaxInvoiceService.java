package com.dm.springbootjpapostgresql.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dm.springbootjpapostgresql.model.entity.TaxInvoice;
import com.dm.springbootjpapostgresql.repository.jpa.TaxInvoiceRepository;

@Service
public class TaxInvoiceService {

	private final Logger log = LoggerFactory.getLogger(TaxInvoiceService.class);

	private TaxInvoiceRepository invoiceRepository;

	public TaxInvoiceService(TaxInvoiceRepository invoiceRepository) {
		super();
		this.invoiceRepository = invoiceRepository;
	}

	@Transactional
	public void generateInvoice(TaxInvoice invoice) {
		if (invoiceRepository.existsById(invoice.getId())) {
			log.info("Invoice id {} already exists - ignored", invoice.getId());
		} else {
			invoiceRepository.save(invoice);
		}
	}

}
