package com.dm.springbootjpapostgresql.dto.montaji;

import lombok.Getter;

@Getter
public class PortDetailsDTO{
    public String portTypeId;
    public String portOfEntryId;
    public String portOfEntryDesc;
    public int countryOfOriginId;
    public String countryOfOriginDesc;
    public String billNumber;
    public String billDate;
    public String arrivalDate;
    public long customsDeclarationNumber;
    public String customsDeclarationDate;
    public String packageTypeId;
    public String packageTypeDesc;
    public int numberOfPackages;
    public String transportNumber;
    public String vesselName;
    public double grossWeight;
    public String remarks;
}