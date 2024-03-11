package com.dm.springbootjpapostgresql.dto.montaji;

import java.util.Date;

import lombok.Setter;

@Setter
public class DashboardResponseDto {
    private String requestNumber;
    private String requestSource;
    private String requestType;
    private Date requestDate;
    private Date creationDate;
    private String requestStatus;
    private String dtReferenceNo;  
    private String licenseNumber;

}
