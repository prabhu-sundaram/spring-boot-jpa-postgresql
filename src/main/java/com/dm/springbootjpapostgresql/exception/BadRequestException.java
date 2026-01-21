package com.dm.springbootjpapostgresql.exception;

public class BadRequestException extends RuntimeException {
  public BadRequestException(String message) { super(message); }
}
