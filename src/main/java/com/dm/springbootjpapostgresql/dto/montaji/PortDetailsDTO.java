package com.dm.springbootjpapostgresql.dto.montaji;

import lombok.Getter;

@Getter
public class PortDetailsDTO{
    private String portTypeId;
    private String portOfEntryId;
    private String portOfEntryDesc;
    private Integer countryOfOriginId;
    private String countryOfOriginDesc;
    private String billNumber;
    private String billDate;
    private String arrivalDate;
    private Long customsDeclarationNumber;
    private String customsDeclarationDate;
    private String packageTypeId;
    private String packageTypeDesc;
    private Integer numberOfPackages;
    private String transportNumber;
    private String vesselName;
    private double grossWeight;
    private String remarks;
}