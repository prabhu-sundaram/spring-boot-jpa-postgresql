package com.dm.springbootjpapostgresql.model.document.montaji;

import lombok.Setter;

@Setter
public class Batch{
    private Integer serialNo;
    private double itemsUnitWeight;
    private Integer itemsQuantity;
    private double itemsTotalWeight;
}
