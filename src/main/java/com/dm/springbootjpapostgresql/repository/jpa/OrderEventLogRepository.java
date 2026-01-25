package com.dm.springbootjpapostgresql.repository.jpa;

import org.springframework.stereotype.Repository;

import com.dm.springbootjpapostgresql.model.entity.OrderEventLog;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderEventLogRepository extends JpaRepository<OrderEventLog, Long>{

}