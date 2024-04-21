package com.dm.springbootjpapostgresql.example.productservice.service;


import java.util.Collection;
import com.dm.springbootjpapostgresql.example.productservice.business.bean.ProductBean;
public interface ProductService {
    Collection<ProductBean> getAllProduct();
    ProductBean getProductDetailsById(int id);
    Integer addProduct(ProductBean product);
    ProductBean updateProduct(ProductBean product);
    void removeProduct(int id);
}
