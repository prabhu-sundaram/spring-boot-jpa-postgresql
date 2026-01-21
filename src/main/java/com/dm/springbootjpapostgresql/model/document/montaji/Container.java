package com.dm.springbootjpapostgresql.model.document.montaji;

import java.util.ArrayList;

import lombok.Setter;

@Setter
public class Container{
    private String serialNo;
    private String containerTypeId;
    private String containerNumber;
    private String storageTemperatureId;
    private Integer containerTotalQuantity;
    private Integer productsCount;
    private double containerTotalWeight;
    private ArrayList<Product> products;
}
