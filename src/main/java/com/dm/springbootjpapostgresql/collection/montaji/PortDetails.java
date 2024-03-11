package com.dm.springbootjpapostgresql.collection.montaji;

import lombok.Setter;

@Setter
public class PortDetails{
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
    private String packageTypeDesc;
    private int numberOfPackages;
    private String transportNumber;
    private String vesselName;
    private double grossWeight;
    private String remarks;
}