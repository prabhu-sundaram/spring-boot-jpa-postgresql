package com.dm.springbootjpapostgresql.exception;

import org.springframework.http.HttpStatus;

public class MontajiMismatchUserCompanyException extends BaseException {

    public MontajiMismatchUserCompanyException() {
        super("User and Company are not matching","105", HttpStatus.BAD_REQUEST);
    }
}
