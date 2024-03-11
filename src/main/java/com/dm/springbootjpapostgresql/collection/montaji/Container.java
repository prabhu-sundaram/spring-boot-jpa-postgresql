package com.dm.springbootjpapostgresql.collection.montaji;

import java.util.ArrayList;

import lombok.Setter;

@Setter
public class Container{
    private String serialNo;
    private String containerTypeId;
    private String containerNumber;
    private String storageTemperatureId;
    private int containerTotalQuantity;
    private int productsCount;
    private double containerTotalWeight;
    private ArrayList<Product> products;
}
