package com.dm.springbootjpapostgresql.dto.montaji;

import lombok.Getter;

@Getter
public class BatchDTO{
    public int serialNo;
    public double itemsUnitWeight;
    public int itemsQuantity;
    public double itemsTotalWeight;
}
