package com.dm.springbootjpapostgresql.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dm.springbootjpapostgresql.model.Country;
import com.dm.springbootjpapostgresql.model.enumeration.Status;

@SpringBootTest 
class CountryRepositoryTest {

    @Autowired
    private CountryRepository countryRepository;

    @Test
    public void saveCountry()
    {
        // Country countryUSA = Country.builder()
        // .name("United States Of America")
        // .build();

        // countryRepository.save(countryUSA);

        // Country countryIN = Country.builder()
        // .name("India")
        // .status(Status.Active)
        // .build();

        // countryRepository.save(countryIN);        

        // Country country = Country.builder()
        // .name("UAE")
        // .status(Status.Inactive)
        // .build();

        // countryRepository.save(country);          

        Country country = Country.builder()
        .name("Pakistan")
        .build();

        countryRepository.save(country);        
    }
    
}
