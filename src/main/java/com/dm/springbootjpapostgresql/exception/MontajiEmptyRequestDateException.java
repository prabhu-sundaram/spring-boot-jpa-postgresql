package com.dm.springbootjpapostgresql.exception;

import org.springframework.http.HttpStatus;

public class MontajiEmptyRequestDateException extends BaseException {

    public MontajiEmptyRequestDateException() {
        super("Empty request date","107", HttpStatus.BAD_REQUEST);
    }
}
