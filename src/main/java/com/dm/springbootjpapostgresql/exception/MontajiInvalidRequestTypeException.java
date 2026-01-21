package com.dm.springbootjpapostgresql.exception;

import org.springframework.http.HttpStatus;

public class MontajiInvalidRequestTypeException extends BaseException {

    public MontajiInvalidRequestTypeException(String message) {
        super("Invalid Request Type: " + message,"106", HttpStatus.BAD_REQUEST);
    }
}
