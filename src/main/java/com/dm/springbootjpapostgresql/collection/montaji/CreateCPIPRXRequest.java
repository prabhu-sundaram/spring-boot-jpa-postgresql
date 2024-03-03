package com.dm.springbootjpapostgresql.collection.montaji;

import com.dm.springbootjpapostgresql.dto.montaji.CompanyDetailsDTO;
import com.dm.springbootjpapostgresql.dto.montaji.ConsignmentDetailsDTO;
import com.dm.springbootjpapostgresql.dto.montaji.ContainerDTO;
import com.dm.springbootjpapostgresql.dto.montaji.PreApprovalDTO;
import com.dm.springbootjpapostgresql.dto.montaji.RequestDetailsDTO;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
// import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "CreateCPIPRXRequest")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateCPIPRXRequest {
    public RequestDetailsDTO requestDetails;
    public CompanyDetailsDTO companyDetails;
    public ConsignmentDetailsDTO consignmentDetails;
    public ArrayList<ContainerDTO> containers;
    public ArrayList<Object> attachments;
    public PreApprovalDTO preApproval;    
}
