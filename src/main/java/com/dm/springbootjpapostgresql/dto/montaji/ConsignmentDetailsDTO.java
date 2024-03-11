package com.dm.springbootjpapostgresql.dto.montaji;

import lombok.Getter;

@Getter
public class ConsignmentDetailsDTO{
    private ConsignmentRequestDetailsDTO requestdetails;
    private PortDetailsDTO portDetails;
}
