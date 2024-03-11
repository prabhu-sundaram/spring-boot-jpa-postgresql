package com.dm.springbootjpapostgresql.dto.montaji;

import java.util.ArrayList;

import lombok.Getter;

@Getter
public class CreateCPIPRXRequestDTO {
    private RequestDetailsDTO requestDetails;
    private CompanyDetailsDTO companyDetails;
    private ConsignmentDetailsDTO consignmentDetails;
    private ArrayList<ContainerDTO> containers;
    private ArrayList<AttachmentContainerDTO> attachments;
    private PreApprovalDTO preApproval;
}
