package com.dm.springbootjpapostgresql.dto.montaji;

import java.util.ArrayList;

import lombok.Getter;

@Getter
public class ContainerDTO{
    public String serialNo;
    public String containerTypeId;
    public String containerNumber;
    public String storageTemperatureId;
    public int containerTotalQuantity;
    public int productsCount;
    public double containerTotalWeight;
    public ArrayList<ProductDTO> products;
}
