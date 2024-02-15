package com.dm.springbootjpapostgresql.utils;

import java.math.BigDecimal;

import jakarta.servlet.http.HttpServletRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UriHelperCountry {

    public static BigDecimal extractIdFromPathParameterAtIndex(HttpServletRequest request, int index) {
        String uri = request.getRequestURI();
        String[] splitUri = uri.split("/");

        if (splitUri.length < (index + 1)) {
            return null;
        }

        String parameter = splitUri[index];
        if (parameter.isEmpty()) {
            return null;
        }

        BigDecimal parameterId = null;
        try {
            parameterId = new BigDecimal(parameter);
        } catch (IllegalArgumentException e) {
            return null;
        }

        return parameterId;
    }    
}
