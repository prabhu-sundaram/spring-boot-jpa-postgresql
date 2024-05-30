package com.dm.springbootjpapostgresql.dto.montaji;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class RequestDetailsDTO{
    private String dtReferenceNo;
    //private String requestNumber;
    private String requestSource;
    private String applicantDMUserId;
    private String requestType;
    private LocalDateTime requestDate;
    private LocalDateTime creationDate;
    private String requestStatus;
    private String createdBy;
}
