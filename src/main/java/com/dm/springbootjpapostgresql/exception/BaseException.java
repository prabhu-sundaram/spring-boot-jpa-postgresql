package com.dm.springbootjpapostgresql.exception;

public abstract class BaseException extends RuntimeException {
    private final String errorCode;

    // Standard constructor with message and code
    public BaseException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    // Constructor for technical errors (wrapping a cause)
    public BaseException(String message, String errorCode, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
