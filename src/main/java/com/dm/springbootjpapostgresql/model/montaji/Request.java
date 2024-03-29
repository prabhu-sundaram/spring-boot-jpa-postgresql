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
@Builder(builderMethodName = "requestBuilder")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "request"
    ,uniqueConstraints = {
                     @UniqueConstraint(columnNames = "request_number")
                    })
//public abstract class Request {
public class Request {    
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
 
}
