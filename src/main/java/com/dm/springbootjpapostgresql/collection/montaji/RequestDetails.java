package com.dm.springbootjpapostgresql.collection.montaji;

import java.util.Date;

import lombok.Setter;

@Setter
public class RequestDetails{
    private String dtReferenceNo;
    private String requestNumber;
    private String requestSource;
    private String applicantDMUserId;
    private String requestType;
    private Date requestDate;
    private Date creationDate;
    private String requestStatus;
}
