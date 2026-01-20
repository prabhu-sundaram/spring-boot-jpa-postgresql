package com.dm.springbootjpapostgresql.exception;

// Business Error
public class InsufficientFundsException extends BaseException {
    public InsufficientFundsException(String message) {
        super(message, "ERR-BANK-001");
    }
}
