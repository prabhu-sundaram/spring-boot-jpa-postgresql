package com.dm.springbootjpapostgresql.mapper;

import java.util.ArrayList;
import java.util.List;

import com.dm.springbootjpapostgresql.model.Country;

import lombok.experimental.UtilityClass;

import com.dm.springbootjpapostgresql.dto.CountryDTO;

@UtilityClass
public class CountryMapper {

    public static List<CountryDTO> convertToListOfCountryDto(List<Country> countries) {
        List<CountryDTO> response = new ArrayList<>();
        for (Country country : countries) {
            response.add(new CountryDTO(country));
        }
        return response;
    }

    public static CountryDTO convertToCountryDto(Country country) {
        return new CountryDTO(country);
    }
}
