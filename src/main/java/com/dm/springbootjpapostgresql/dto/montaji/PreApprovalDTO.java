package com.dm.springbootjpapostgresql.dto.montaji;

import lombok.Getter;

@Getter
public class PreApprovalDTO{
    private String dip;
    private long dipWarehouseId;
    private String releaseWithDetention;
    private long releaseWithDetentionWarehouseId;
    private String sampleDetention;
    private long sampleDetentionWarehouseId;
}
