package com.dm.springbootjpapostgresql.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private record Product(Integer productId,String productName,double price){}

    List <Product> products = new ArrayList<>(
            List.of(
                    new Product(1,"hp laptop",6000),
                    new Product(2,"hp mouse",100)
            )
    );
    @GetMapping
    public List<Product>  getAllProducts()
    {
        return products;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product)
    {
        products.add(product);
        return product;
    }

}
