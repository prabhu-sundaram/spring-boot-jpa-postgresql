package com.dm.springbootjpapostgresql.exception;

public class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException(String message) { super(message); }
}