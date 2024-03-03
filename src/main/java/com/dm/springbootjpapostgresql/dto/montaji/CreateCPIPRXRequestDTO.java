package com.dm.springbootjpapostgresql.dto.montaji;

import java.util.ArrayList;

public class CreateCPIPRXRequestDTO {
    public RequestDetailsDTO requestDetails;
    public CompanyDetailsDTO companyDetails;
    public ConsignmentDetailsDTO consignmentDetails;
    public ArrayList<ContainerDTO> containers;
    public ArrayList<AttachmentContainerDTO> attachments;
    public PreApprovalDTO preApproval;
}
