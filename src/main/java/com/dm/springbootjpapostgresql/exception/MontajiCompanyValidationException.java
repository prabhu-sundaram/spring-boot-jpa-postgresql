package com.dm.springbootjpapostgresql.exception;

import org.springframework.http.HttpStatus;

public class MontajiCompanyValidationException extends BaseException {

    public MontajiCompanyValidationException(String message) {
        super("Company not found with " + message,"002", HttpStatus.BAD_REQUEST);
    }
}
