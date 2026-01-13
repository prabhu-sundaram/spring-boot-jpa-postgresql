package com.dm.springbootjpapostgresql.model.entity.pojo.inheritance.SingleTable;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "product_type", discriminatorType = DiscriminatorType.INTEGER)
// @DiscriminatorFormula("case when author is not null then 1 else 2 end")
public class MyProduct {
    @Id
    private Long productId;

    private String name;

    public MyProduct() {
    }

    public MyProduct(Long productId, String name) {
        super();
        this.productId = productId;
        this.name = name;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

