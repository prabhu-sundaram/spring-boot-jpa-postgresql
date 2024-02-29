package com.dm.springbootjpapostgresql.dto.montaji;

import java.util.ArrayList;

public class CreateCPIPRXRequestDTO {
    public RequestDetails requestDetails;
    public CompanyDetails companyDetails;
    public ConsignmentDetails consignmentDetails;
    public ArrayList<Container> containers;
    public ArrayList<Object> attachments;
    public PreApproval preApproval;
}
