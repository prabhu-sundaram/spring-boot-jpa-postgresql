package com.dm.springbootjpapostgresql.model.document.montaji;

import lombok.Setter;

@Setter
public class Batch{
    private int serialNo;
    private double itemsUnitWeight;
    private int itemsQuantity;
    private double itemsTotalWeight;
}
