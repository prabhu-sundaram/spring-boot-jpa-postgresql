package com.dm.springbootjpapostgresql.controller;

import com.dm.springbootjpapostgresql.utils.response.GlobalResponse;
import com.dm.springbootjpapostgresql.SpringBootJpaPostgresqlApplication;
import com.dm.springbootjpapostgresql.dto.CountryDTO;
import com.dm.springbootjpapostgresql.mapper.CountryMapper;
import com.dm.springbootjpapostgresql.model.Country;
import com.dm.springbootjpapostgresql.model.enumeration.Status;
import com.dm.springbootjpapostgresql.service.CountryService;
//import com.unboundid.util.Nullable;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/countries")
public class CountryController {
    private static final Logger logger = LoggerFactory.getLogger(SpringBootJpaPostgresqlApplication.class);

    private final CountryService countryService;

    @GetMapping
    //public ResponseEntity<GlobalResponse<List<CountryDTO>>> getCountries(@Valid @RequestParam @Nullable Status status) {
    public ResponseEntity<GlobalResponse<List<CountryDTO>>> getCountries(@Valid @RequestParam Status status) {

        List<Country> countries = (status != null) ? countryService.getCountries(status)
                : countryService.getCountries();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new GlobalResponse<>(CountryMapper.convertToListOfCountryDto(countries)));

    }

    @GetMapping("/{countryId}")
    public ResponseEntity<GlobalResponse<CountryDTO>> getCountryByIsoCode(@PathVariable BigDecimal countryId,
                                                                          @RequestAttribute("country") Country country) {
        logger.info("Request attribute in controller = {}", country);
        CountryDTO countryDTO = CountryMapper.convertToCountryDto(country);

        return ResponseEntity.status(HttpStatus.OK).body(new GlobalResponse<>(countryDTO));
    }

    @PutMapping("/{countryId}")
    public ResponseEntity<GlobalResponse<CountryDTO>> updateCountryStatus(@PathVariable BigDecimal countryId,
                                                                          @RequestParam Status status) {
        Country country = countryService.updateCountryStatus(countryId, status);
        CountryDTO countryDTO = CountryMapper.convertToCountryDto(country);

        return ResponseEntity.status(HttpStatus.OK).body(new GlobalResponse<>(countryDTO));
    }
}

