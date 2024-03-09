package com.dm.springbootjpapostgresql.dto.montaji;

import java.util.Date;

import lombok.Getter;

@Getter
public class RequestDetailsDTO{
    public String dtReferenceNo;
    public String requestNumber;
    public String requestSource;
    public String applicantDMUserId;
    public String requestType;
    public Date requestDate;
    public Date creationDate;
    public String requestStatus;
}
