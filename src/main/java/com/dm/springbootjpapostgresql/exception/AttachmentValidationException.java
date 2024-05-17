package com.dm.springbootjpapostgresql.exception;

public class AttachmentValidationException extends RuntimeException {

    public AttachmentValidationException(String message) {
        super(message);
    }
}