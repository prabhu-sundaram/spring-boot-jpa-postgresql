package com.dm.springbootjpapostgresql.model.document.montaji;

import lombok.Setter;

@Setter
public class PreApproval{
    private String dip;
    private Long dipWarehouseId;
    private String releaseWithDetention;
    private Long releaseWithDetentionWarehouseId;
    private String sampleDetention;
    private Long sampleDetentionWarehouseId;
}
