package com.dm.springbootjpapostgresql.exception;

// Technical Error
public class DatabaseMappingException extends BaseException {
    public DatabaseMappingException(String message, Throwable cause) {
        super(message, "ERR-DB-500", cause);
    }
}
