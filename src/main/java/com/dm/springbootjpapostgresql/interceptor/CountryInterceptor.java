package com.dm.springbootjpapostgresql.interceptor;

import com.dm.springbootjpapostgresql.SpringBootJpaPostgresqlApplication;
import com.dm.springbootjpapostgresql.model.Country;
import com.dm.springbootjpapostgresql.service.CountryService;
import com.dm.springbootjpapostgresql.utils.UriHelperCountry;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Map;

@Component
public class CountryInterceptor implements HandlerInterceptor {

//private static final Logger logger = LoggerFactory.getLogger(SpringBootJpaPostgresqlApplication.class);
private static final Logger logger = LoggerFactory.getLogger(CountryInterceptor.class);

    @Autowired
    private CountryService countryService;

    public CountryInterceptor(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        // extract & check if the path parameter is present
        //BigDecimal countryId = UriHelperCountry.extractIdFromPathParameterAtIndex(request, 3);

    if (!(handler instanceof HandlerMethod handlerMethod)) {
        return true;
    }

    logger.info("URI variables = {}", 
    request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE));

    Map<String, String> uriVariables =
        (Map<String, String>) request.getAttribute(
            HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE
        );

    String countryIdStr = (uriVariables == null) ? null : uriVariables.get("countryId");

    if (countryIdStr == null) {
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return false;
    }

    BigDecimal countryId;
    try {
        countryId = new BigDecimal(countryIdStr);
    } catch (NumberFormatException ex) {
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
        logger.info("Setting request attribute country={}", country);


        return true;
    }
}

