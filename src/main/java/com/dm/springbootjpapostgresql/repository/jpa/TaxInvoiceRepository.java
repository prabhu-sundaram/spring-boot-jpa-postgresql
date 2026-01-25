package com.dm.springbootjpapostgresql.repository.jpa;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.dm.springbootjpapostgresql.model.entity.TaxInvoice;

public interface TaxInvoiceRepository extends PagingAndSortingRepository<TaxInvoice, Long>, CrudRepository<TaxInvoice, Long> {

	@Query("SELECT max(i.updated) FROM TaxInvoice i")
	Date lastUpdate();

}
