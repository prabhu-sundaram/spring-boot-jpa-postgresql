package com.dm.springbootjpapostgresql.dto.montaji;

import lombok.Getter;

@Getter
public class BatchDTO{
    private int serialNo;
    private double itemsUnitWeight;
    private int itemsQuantity;
    private double itemsTotalWeight;
}
