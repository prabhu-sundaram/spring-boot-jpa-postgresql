package com.dm.springbootjpapostgresql.model.entity.pojo.inheritance.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Book2 extends MyProduct {
    private String author;

    public Book2() {
    }

    public Book2(Long productId, String name, String author) {
        super(productId, name);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
