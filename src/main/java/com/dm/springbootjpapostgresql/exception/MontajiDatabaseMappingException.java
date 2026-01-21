package com.dm.springbootjpapostgresql.exception;

import org.springframework.http.HttpStatus;

// Technical Error
public class MontajiDatabaseMappingException extends BaseException {
    public MontajiDatabaseMappingException(String message, Throwable cause) {
        super(message, cause, "ERR-DB-500", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
