package com.dm.springbootjpapostgresql.interceptor;

import com.dm.springbootjpapostgresql.model.Country;
import com.dm.springbootjpapostgresql.service.CountryService;
import com.dm.springbootjpapostgresql.utils.UriHelperCountry;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.math.BigDecimal;

@Component
public class CountryInterceptor implements HandlerInterceptor {

    @Autowired
    private CountryService countryService;

    public CountryInterceptor(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        // extract & check if the path parameter is present
        BigDecimal countryId = UriHelperCountry.extractIdFromPathParameterAtIndex(request, 3);
        if (countryId == null) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return false;
        }

        // Validate the path parameter against database record
        Country country = countryService.getCountryById(countryId);
        if (country == null) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return false;
        }

        // Adding the group to the request attributes
        request.setAttribute("country", country);

        return true;
    }
}

