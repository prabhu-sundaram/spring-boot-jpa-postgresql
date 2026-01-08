package com.dm.springbootjpapostgresql.service.impl;

import com.dm.springbootjpapostgresql.model.entity.Country;
import com.dm.springbootjpapostgresql.model.entity.enumeration.Status;
import com.dm.springbootjpapostgresql.repository.jpa.CountryRepository;
import com.dm.springbootjpapostgresql.service.CountryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public List<Country> getCountries(Status status) {
        return countryRepository.findByStatus(status);
    }

    @Override
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country getCountryById(BigDecimal id) {
        return this.countryRepository.findById(id).orElse(null);
    }

    @Override
    public Country updateCountryStatus(BigDecimal id, Status status) {
        Country country = getCountryById(id);

        if (country != null) {
            country.setStatus(status);
            countryRepository.save(country);

            return country;
        } else {
            return null;
        }
    }
}
