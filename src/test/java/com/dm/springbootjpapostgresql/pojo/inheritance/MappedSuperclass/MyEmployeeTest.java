package com.dm.springbootjpapostgresql.pojo.inheritance.MappedSuperclass;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.dm.springbootjpapostgresql.repository2.MyEmployeeRepository;

@SpringBootTest 
public class MyEmployeeTest {

    @Autowired
    private MyEmployeeRepository myEmployeeRepository;

    @Test
    void testGetCompany() {

    }

    @Test
    void testSetCompany() {

        MyEmployee emp = new MyEmployee(1, "john", "baeldung");
        myEmployeeRepository.save(emp);
        
        List<MyEmployee> employees = myEmployeeRepository.findAll();
        assertThat(employees).isNotEmpty();
    }
}
