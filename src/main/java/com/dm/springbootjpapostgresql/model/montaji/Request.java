package com.dm.springbootjpapostgresql.model.montaji;

import java.util.Date;

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
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // Specify table-per-class inheritance
@Table(name = "request"
    ,uniqueConstraints = {
                     @UniqueConstraint(columnNames = "request_number")
                    })
public abstract class Request {
    @Id  
    @Column(name = "request_number", nullable = false)
    private String requestNumber;
    private String requestSource;
    private String requestType;
    private Date requestDate;
    private Date creationDate;
    private String requestStatus;    
    private String dtReferenceNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "license_number", nullable = false)
    private CompanyDetails companyDetails;        

    // public static RequestBuilder builder() {
    //     return new RequestBuilder();
    // }

    // public static class RequestBuilder {
    //     private String requestNumber;
    //     private String requestSource;
    //     private String requestType;
    //     private Date requestDate;
    //     private Date creationDate;
    //     private String requestStatus;
    //     private String dtReferenceNo;
    //     private CompanyDetails companyDetails;

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


    //     public Request build() {
    //         Request request = new Request();
    //         request.setRequestNumber(this.requestNumber);
    //         request.setRequestSource(this.requestSource);
    //         request.setRequestType(this.requestType);
    //         request.setRequestDate(this.requestDate);
    //         request.setCreationDate(this.creationDate);
    //         request.setRequestStatus(this.requestStatus);
    //         request.setDtReferenceNo(this.dtReferenceNo);
    //         request.setCompanyDetails(this.companyDetails);
    //         return request;
    //     }
    // }    
}
