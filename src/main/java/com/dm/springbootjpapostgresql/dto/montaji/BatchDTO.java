package com.dm.springbootjpapostgresql.dto.montaji;

import lombok.Getter;

@Getter
public class BatchDTO{
    private Integer serialNo;
    private double itemsUnitWeight;
    private Integer itemsQuantity;
    private double itemsTotalWeight;
}
