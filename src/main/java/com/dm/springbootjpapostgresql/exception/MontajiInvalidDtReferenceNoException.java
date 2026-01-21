package com.dm.springbootjpapostgresql.exception;

import org.springframework.http.HttpStatus;

public class MontajiInvalidDtReferenceNoException extends BaseException {

    public MontajiInvalidDtReferenceNoException(String message) {
        super("Invalid DT reference no: " + message,"102", HttpStatus.BAD_REQUEST);
    }
}
