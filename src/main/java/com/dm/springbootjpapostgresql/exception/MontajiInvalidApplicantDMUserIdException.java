package com.dm.springbootjpapostgresql.exception;

import org.springframework.http.HttpStatus;

public class MontajiInvalidApplicantDMUserIdException extends BaseException {

    public MontajiInvalidApplicantDMUserIdException(String message) {
        super("Invalid Applicant DM User Id: " + message,"104", HttpStatus.BAD_REQUEST);
    }
}
