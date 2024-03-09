package com.dm.springbootjpapostgresql.dto.montaji;

import lombok.Getter;

@Getter
public class PreApprovalDTO{
    public String dip;
    public long dipWarehouseId;
    public String releaseWithDetention;
    public long releaseWithDetentionWarehouseId;
    public String sampleDetention;
    public long sampleDetentionWarehouseId;
}
