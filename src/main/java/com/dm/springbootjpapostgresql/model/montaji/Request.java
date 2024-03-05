package com.dm.springbootjpapostgresql.model.montaji;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "request"
    ,uniqueConstraints = {
                     @UniqueConstraint(columnNames = "request_number")
                    })
public class Request {
    @Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
