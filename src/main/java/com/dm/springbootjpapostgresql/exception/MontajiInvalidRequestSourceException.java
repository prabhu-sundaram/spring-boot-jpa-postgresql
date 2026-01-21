package com.dm.springbootjpapostgresql.exception;

import org.springframework.http.HttpStatus;

public class MontajiInvalidRequestSourceException extends BaseException {

    public MontajiInvalidRequestSourceException(String message) {
        super("Invalid Request Source: " + message,"101", HttpStatus.BAD_REQUEST);
    }
}
