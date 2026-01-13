package com.dm.springbootjpapostgresql.dto.montaji;

import lombok.Getter;

@Getter
public class PreApprovalDTO{
    private String dip;
    private Long dipWarehouseId;
    private String releaseWithDetention;
    private Long releaseWithDetentionWarehouseId;
    private String sampleDetention;
    private Long sampleDetentionWarehouseId;
}
