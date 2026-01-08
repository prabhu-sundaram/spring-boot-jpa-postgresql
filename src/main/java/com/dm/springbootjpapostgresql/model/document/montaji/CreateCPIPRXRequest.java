package com.dm.springbootjpapostgresql.model.document.montaji;

import com.dm.springbootjpapostgresql.model.document.montaji.CompanyDetails;
import com.dm.springbootjpapostgresql.model.document.montaji.ConsignmentDetails;
import com.dm.springbootjpapostgresql.model.document.montaji.Container;
import com.dm.springbootjpapostgresql.model.document.montaji.PreApproval;
import com.dm.springbootjpapostgresql.model.document.montaji.RequestDetails;
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
//@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "CreateCPIPRXRequest")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateCPIPRXRequest {
    public RequestDetails requestDetails;
    public CompanyDetails companyDetails;
    public ConsignmentDetails consignmentDetails;
    public ArrayList<Container> containers;
    public ArrayList<Object> attachments;
    public PreApproval preApproval;    
}
