package com.dm.springbootjpapostgresql.exception;

import org.springframework.http.HttpStatus;

public class MontajiAttachmentValidationException extends BaseException {

    public MontajiAttachmentValidationException(String message) {
        super("Validation error: " + message,"201", HttpStatus.BAD_REQUEST);
    }
}
