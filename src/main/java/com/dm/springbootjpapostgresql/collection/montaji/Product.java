package com.dm.springbootjpapostgresql.collection.montaji;

import java.util.ArrayList;

import lombok.Setter;

@Setter
public class Product{
    private long _id;
    private String barcode;
    private String productId;
    private String groupId;
    private String categoryId;
    private String subCategoryId;
    private String countryId;
    private String brandId;
    private int noOfBatches;
    private int productTotalQuantity;
    private double productUnitWeight;
    private double productTotalWeight;
    private ArrayList<Batch> batches;
}
