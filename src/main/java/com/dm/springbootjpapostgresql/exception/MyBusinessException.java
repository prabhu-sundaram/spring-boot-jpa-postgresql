package com.dm.springbootjpapostgresql.exception;

public class MyBusinessException extends RuntimeException {

    // 1. No message
    public MyBusinessException() {
        super();
    }

    // 2. Custom message (The one you use most)
    public MyBusinessException(String message) {
        super(message);
    }

    // 3. Wrap another error (e.g., wrap a SQLException)
    public MyBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    // 4. Only the cause
    public MyBusinessException(Throwable cause) {
        super(cause);
    }
}
