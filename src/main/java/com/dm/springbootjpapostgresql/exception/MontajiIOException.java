package com.dm.springbootjpapostgresql.exception;

import org.springframework.http.HttpStatus;

public class MontajiIOException extends BaseException {

    public MontajiIOException(String message, Throwable cause) 
    { 
        super(message, cause, "202", HttpStatus.INTERNAL_SERVER_ERROR); // 'cause' preserves the original IOException stack trace
    }
}
