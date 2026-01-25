package com.dm.springbootjpapostgresql.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.springbootjpapostgresql.model.entity.TaxInvoice;
import com.dm.springbootjpapostgresql.repository.jpa.TaxInvoiceRepository;

@RestController
@RequestMapping("/api/taxInvoice")
public class TaxInvoiceController {

    private final TaxInvoiceRepository invoiceRepository;

    public TaxInvoiceController(TaxInvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    // Fetches a specific invoice; returns 404 if not found
    @GetMapping("/{id}")
    public ResponseEntity<TaxInvoice> getInvoice(@PathVariable("id") Long id) {
        return invoiceRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Returns the list of all invoices as a JSON array
    @GetMapping
    public ResponseEntity<Iterable<TaxInvoice>> getAllInvoices() {
        return ResponseEntity.ok(invoiceRepository.findAll());
    }
}
