package com.dm.springbootjpapostgresql.model.document.montaji;

import lombok.Setter;

@Setter
public class ConsignmentDetails{
    private ConsignmentRequestDetails requestdetails;
    private PortDetails portDetails;
}
