package com.dm.springbootjpapostgresql.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException(String message) { super(message); }
}