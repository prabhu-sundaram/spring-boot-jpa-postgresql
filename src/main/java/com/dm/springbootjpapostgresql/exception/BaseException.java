package com.dm.springbootjpapostgresql.exception;

import org.springframework.http.HttpStatus;

public abstract class BaseException extends RuntimeException {
    private final String errorCode;
    private final HttpStatus status;

    // No message
    public BaseException() {
        super();
        this.errorCode = "999";
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;   
    }

    // Standard constructor with message and code
    public BaseException(String message, String errorCode, HttpStatus status) {
        super(message);
        this.errorCode = errorCode;
        this.status = status;
    }

    // Constructor for technical errors (wrapping a cause)
    public BaseException(String message, Throwable cause, String errorCode, HttpStatus status) {
        super(message, cause);
        this.errorCode = errorCode;
        this.status = status;
    }

    // Only the cause
    public BaseException(Throwable cause) {
        super(cause);
        this.errorCode = "999";
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }    

    public String getErrorCode() {
        return errorCode;
    }

    public HttpStatus getStatus() { 
        return status; 
    }    
}
