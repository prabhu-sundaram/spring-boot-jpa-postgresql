package com.dm.springbootjpapostgresql.dto.montaji;

import java.util.ArrayList;

import lombok.Getter;

@Getter
public class ProductDTO{
    private Long _id;
    private String barcode;
    private String productId;
    private String groupId;
    private String categoryId;
    private String subCategoryId;
    private String countryId;
    private String brandId;
    private Integer productTotalQuantity;
    private double productUnitWeight;
    private double productTotalWeight;
    private ArrayList<BatchDTO> batches;
}
