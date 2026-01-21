package com.dm.springbootjpapostgresql.exception;

import org.springframework.http.HttpStatus;

public class MontajiDuplicateReuestException extends BaseException {

    public MontajiDuplicateReuestException(String message) {
        super("Duplicate request found with dtReferenceNo: " + message,"103", HttpStatus.BAD_REQUEST);
    }
}
