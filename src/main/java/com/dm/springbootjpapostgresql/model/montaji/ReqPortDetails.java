package com.dm.springbootjpapostgresql.model.montaji;

import com.dm.springbootjpapostgresql.model.Post;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "req_port_details")
public class ReqPortDetails{
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    private String portTypeId;
    private String portOfEntryId;
    private String portOfEntryDesc;
    private int countryOfOriginId;
    private String countryOfOriginDesc;
    private String billNumber;
    private String billDate;
    private String arrivalDate;
    private long customsDeclarationNumber;
    private String customsDeclarationDate;
    private String packageTypeId;
    private int numberOfPackages;
    private String transportNumber;
    private String vesselName;
    private double grossWeight;
    private String remarks;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_id", nullable = false)
    private Request request;    
}    