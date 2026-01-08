package com.dm.springbootjpapostgresql.repository2;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dm.springbootjpapostgresql.model.entity.Book;
import com.dm.springbootjpapostgresql.model.entity.pojo.inheritance.SingleTable.Book2;
import com.dm.springbootjpapostgresql.model.entity.pojo.inheritance.SingleTable.MyProduct;
import com.dm.springbootjpapostgresql.model.entity.pojo.inheritance.SingleTable.Pen;
import com.dm.springbootjpapostgresql.repository.jpa.repository2.Book2Repository;
import com.dm.springbootjpapostgresql.repository.jpa.repository2.MyProductRepository;
import com.dm.springbootjpapostgresql.repository.jpa.repository2.PenRepository;

@SpringBootTest
public class MyProductRepositoryTest {

@Autowired
private Book2Repository book2Repository;

@Autowired
private PenRepository penRepository;

@Autowired
private MyProductRepository myProductRepository;

@Test
public void testSingleTable()
{

    Book2 book = new Book2(1, "1984", "George Orwell");
    book2Repository.save(book);

    Pen pen = new Pen(2, "my pen", "blue");
    penRepository.save(pen);

    List<MyProduct> myProducts = myProductRepository.findAll();
    System.out.println("myProducts:"+myProducts.size());

    

}
}
