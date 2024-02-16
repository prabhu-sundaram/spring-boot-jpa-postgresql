package com.dm.springbootjpapostgresql.interceptor;


import com.dm.springbootjpapostgresql.dto.CountryDTO;
import com.dm.springbootjpapostgresql.mapper.CountryMapper;
import com.dm.springbootjpapostgresql.model.Country;
import com.dm.springbootjpapostgresql.model.enumeration.Status;
import com.dm.springbootjpapostgresql.service.CountryService;
import lombok.RequiredArgsConstructor;
// import org.dm.constants.ApiStatusCodes;
// import org.dm.constants.graphql.ErrorTypes;
// import org.dm.exceptions.CustomErrorException;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.ContextValue;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CountryGraphQlController {

    private final CountryService countryService;

    @QueryMapping(name = "getCountries")
    public List<CountryDTO> getCountries(@Argument Status status) {
        List<CountryDTO> countries = (status != null)
                ? CountryMapper.convertToListOfCountryDto(countryService.getCountries(status))
                : CountryMapper.convertToListOfCountryDto(countryService.getCountries());
        return countries;
    }

    @QueryMapping(name = "getCountryByIsoCode")
    public CountryDTO getCountryByIsoCode(@Argument BigDecimal id, @ContextValue Country country) {
        CountryDTO countryDTO = CountryMapper.convertToCountryDto(country);
        return countryDTO;
    }

    // @MutationMapping(name = "updateCountryStatus")
    // public CountryDTO updateCountryStatus(@Argument BigDecimal id, @Argument Status status) {
    //     Country country = countryService.updateCountryStatus(id, status);
    //     if (country == null) {
    //         throw new CustomErrorException(ApiStatusCodes.ENTITY_NOTFOUND, ErrorTypes.NOT_FOUND);
    //     }
    //     return CountryMapper.convertToCountryDto(country);
    // }
}

