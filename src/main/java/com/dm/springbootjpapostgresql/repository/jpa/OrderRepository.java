package com.dm.springbootjpapostgresql.repository.jpa;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.dm.springbootjpapostgresql.model.entity.Order;

@RepositoryRestResource(collectionResourceRel = "order", path = "order")
public interface OrderRepository extends PagingAndSortingRepository<Order, Long>, CrudRepository<Order, Long> {

	@Query("SELECT max(o.updated) FROM Order o")
	Date lastUpdate();

	Order getReferenceById(Long orderId);

}