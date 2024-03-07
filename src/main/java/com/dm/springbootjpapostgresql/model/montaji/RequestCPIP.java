package com.dm.springbootjpapostgresql.model.montaji;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Builder
@Entity
@Table(name = "req_cpip")
public class RequestCPIP extends Request{
	// @Id  
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "id", nullable = false)
	// private Long id;    
    
    private String consignmentPurposeId;   

    @OneToOne(mappedBy = "requestCPIP", cascade = CascadeType.ALL, orphanRemoval = true)
    private ReqPortDetails reqPortDetails;

    @OneToMany(mappedBy = "requestCPIP", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Container> containers;    

    @OneToOne(mappedBy = "requestCPIP", cascade = CascadeType.ALL, orphanRemoval = true)
    private PreApproval preApproval;    

    // @OneToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "request_number", nullable = false)
    // private Request request;
 

    // public static RequestCPIPBuilder builder() {
    //     return new RequestCPIPBuilder();
    // }

    // public static class RequestCPIPBuilder {

    //     private String requestNumber;
    //     private String requestSource;
    //     private String requestType;
    //     private Date requestDate;
    //     private Date creationDate;
    //     private String requestStatus;
    //     private String dtReferenceNo;
    //     private CompanyDetails companyDetails;
    //     private String consignmentPurposeId;

    //     public RequestBuilder requestNumber(String requestNumber) {
    //         this.requestNumber = requestNumber;
    //         return this;
    //     }
    //     public RequestBuilder requestSource(String requestSource) {
    //         this.requestSource = requestSource;
    //         return this;
    //     }         
    //     public RequestBuilder requestType(String requestType) {
    //         this.requestType = requestType;
    //         return this;
    //     }        
    //     public RequestBuilder requestDate(Date requestDate) {
    //         this.requestDate = requestDate;
    //         return this;
    //     }
    //     public RequestBuilder creationDate(Date creationDate) {
    //         this.creationDate = creationDate;
    //         return this;
    //     }
    //     public RequestBuilder requestStatus(String requestStatus) {
    //         this.requestStatus = requestStatus;
    //         return this;
    //     }
    //     public RequestBuilder dtReferenceNo(String dtReferenceNo) {
    //         this.dtReferenceNo = dtReferenceNo;
    //         return this;
    //     }
    //     public RequestBuilder companyDetails(CompanyDetails companyDetails) {
    //         this.companyDetails = companyDetails;
    //         return this;
    //     }


    
    //     public RequestCPIPBuilder consignmentPurposeId(String consignmentPurposeId) {
    //         this.consignmentPurposeId = consignmentPurposeId;
    //         return this;
    //     }
    
    //     @Override
    //     public RequestCPIP build() {
    //         RequestCPIP requestCPIP = new RequestCPIP();
    //         requestCPIP.setConsignmentPurposeId(this.consignmentPurposeId);
    //         // Set other properties inherited from Request
    //         requestCPIP.setRequestNumber(this.requestNumber);
    //         requestCPIP.setDtReferenceNo(this.dtReferenceNo);
    //         requestCPIP.setRequestSource(this.requestSource);
    //         requestCPIP.setRequestDate(this.requestDate);
    //         requestCPIP.setCreationDate(this.creationDate);
    //         requestCPIP.setRequestStatus(this.requestStatus);
    //         requestCPIP.setCompanyDetails(this.companyDetails);
    //         return requestCPIP;
    //     }
    // }

}

