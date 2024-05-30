package com.dm.springbootjpapostgresql.dto.montaji;

import java.util.ArrayList;

import lombok.Getter;

@Getter
public class ContainerDTO{
    private String serialNo;
    private String containerTypeId;
    private String containerNumber;
    private String storageTemperatureId;
    private int containerTotalQuantity;
    //private int productsCount;
    private double containerTotalWeight;
    private ArrayList<ProductDTO> products;
}
