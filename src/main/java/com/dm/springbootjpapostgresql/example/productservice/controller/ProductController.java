package com.dm.springbootjpapostgresql.example.productservice.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.dm.springbootjpapostgresql.example.productservice.business.bean.ProductBean;
import com.dm.springbootjpapostgresql.example.productservice.service.ProductServiceImpl;

@RestController
public class ProductController {

 @Autowired

 private ProductServiceImpl productServiceImpl;

 

 @GetMapping(value = "product/controller/getDetails", produces = MediaType.APPLICATION_JSON_VALUE )

 public ResponseEntity<List<ProductBean>> getProductDetails() {

     List<ProductBean> listProduct = new ArrayList<ProductBean>(productServiceImpl.getAllProduct());

     return new ResponseEntity<List<ProductBean>>(listProduct,HttpStatus.OK);

 }


 @GetMapping(value="product/controller/getDetailsById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)

 public ResponseEntity<ProductBean> getProductDetailByEmployeeId(@PathVariable("id") int myId) {

     ProductBean product = productServiceImpl.getProductDetailsById(myId);

     if (product != null) {

         return new ResponseEntity<ProductBean>(product, HttpStatus.OK);

     } else {

         return new ResponseEntity<ProductBean>(HttpStatus.NOT_FOUND);

     }

 }


 @PostMapping(value="product/controller/addProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_HTML_VALUE)

 public ResponseEntity<String> addProduct(@RequestBody ProductBean product) {

     int count=productServiceImpl.addProduct(product);

     return new ResponseEntity<String>("Product added successfully with id:" + count,HttpStatus.CREATED);

 }

 

 @PutMapping(value = "product/controller/updateProduct",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

 public ResponseEntity<ProductBean> updateProduct(@RequestBody  ProductBean product) {

     if (productServiceImpl.getProductDetailsById(product.getId()) == null) {

         ProductBean product2 = null;

         return new ResponseEntity<ProductBean>(product2,HttpStatus.INTERNAL_SERVER_ERROR);

     }

     ProductBean updated = productServiceImpl.updateProduct(product);

     return new ResponseEntity<ProductBean>(updated, HttpStatus.OK);

 }


 @DeleteMapping(value = "product/controller/deleteProduct/{id}", produces = MediaType.APPLICATION_JSON_VALUE)

 public ResponseEntity<ProductBean> deleteProduct(@PathVariable("id") int myId) {

     ProductBean product2=productServiceImpl.getProductDetailsById(myId);

     if (productServiceImpl.getProductDetailsById(myId) == null) {

         return new ResponseEntity<ProductBean>(product2,HttpStatus.INTERNAL_SERVER_ERROR);

     }

     productServiceImpl.removeProduct(myId);

     return new ResponseEntity<ProductBean>(product2, HttpStatus.OK);

 }

}

