package com.dm.springbootjpapostgresql.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dm.springbootjpapostgresql.model.Country;
import com.dm.springbootjpapostgresql.model.enumeration.Status;

@Repository
public interface CountryRepository extends JpaRepository<Country, BigDecimal> {
    List<Country> findByStatus(Status status);
}

