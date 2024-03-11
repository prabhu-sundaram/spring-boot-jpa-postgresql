package com.dm.springbootjpapostgresql.collection.montaji;

import lombok.Setter;

@Setter
public class PreApproval{
    private String dip;
    private long dipWarehouseId;
    private String releaseWithDetention;
    private long releaseWithDetentionWarehouseId;
    private String sampleDetention;
    private long sampleDetentionWarehouseId;
}
