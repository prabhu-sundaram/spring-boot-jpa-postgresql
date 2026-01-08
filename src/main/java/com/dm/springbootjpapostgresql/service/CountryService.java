package com.dm.springbootjpapostgresql.service;

import java.math.BigDecimal;
import java.util.List;

import com.dm.springbootjpapostgresql.model.entity.Country;
import com.dm.springbootjpapostgresql.model.entity.enumeration.Status;

public interface CountryService {

    List<Country> getCountries(Status status);

    List<Country> getCountries();

    Country getCountryById(BigDecimal id);

    Country updateCountryStatus(BigDecimal id, Status status);
}
