package com.dm.springbootjpapostgresql.model.entity.montaji;

import java.time.LocalDateTime;
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
    private LocalDateTime requestDate;
    private LocalDateTime creationDate;
    private String requestStatus;    
    private String dtReferenceNo;

    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Attachment> attachments;  
        
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "license_number", nullable = false)
    private CompanyDetails companyDetails;    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", nullable = false, referencedColumnName = "user_name")
    private User user;            
 
    
}
