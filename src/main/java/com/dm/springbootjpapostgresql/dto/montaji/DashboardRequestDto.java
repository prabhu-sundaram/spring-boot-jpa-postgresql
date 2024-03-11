package com.dm.springbootjpapostgresql.dto.montaji;

import java.util.Date;

import lombok.Getter;

@Getter
public class DashboardRequestDto {
    private String requestNumber;
    private String requestSource;
    private String requestType;
    private Date requestDate;
    private Date creationDate;
    private String requestStatus;
    private String dtReferenceNo;  
    private String licenseNumber;
    private String billNumber;
    private String containerNumber;



}
