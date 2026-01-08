package com.dm.springbootjpapostgresql.model.entity.montaji;

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
@Builder
@Entity
@Table(name = "req_port_details")
public class ReqPortDetails{
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
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
    @JoinColumn(name = "request_number", nullable = false)
    private RequestCPIP requestCPIP;  
}    