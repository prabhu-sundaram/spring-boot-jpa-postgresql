package com.dm.springbootjpapostgresql.dto.montaji;

import java.util.Date;

import lombok.Getter;

@Getter
public class RequestDetailsDTO{
    private String dtReferenceNo;
    private String requestNumber;
    private String requestSource;
    private String applicantDMUserId;
    private String requestType;
    private Date requestDate;
    private Date creationDate;
    private String requestStatus;
    private String createdBy;
}
