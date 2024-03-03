package com.dm.springbootjpapostgresql.dto.montaji;

import java.util.ArrayList;

public class ProductDTO{
    public long _id;
    public String barcode;
    public String productId;
    public String groupId;
    public String categoryId;
    public String subCategoryId;
    public String countryId;
    public String brandId;
    public int noOfBatches;
    public int productTotalQuantity;
    public double productUnitWeight;
    public double productTotalWeight;
    public ArrayList<BatchDTO> batches;
}
