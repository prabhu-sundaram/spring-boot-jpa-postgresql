package com.dm.springbootjpapostgresql.pojo.inheritance.MappedSuperclass;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.dm.springbootjpapostgresql.model.entity.pojo.inheritance.MappedSuperclass.MyEmployee;
import com.dm.springbootjpapostgresql.repository.jpa.repository2.MyEmployeeRepository;
import com.dm.springbootjpapostgresql.repository.jpa.repository2.Person3Repository;

@SpringBootTest 
public class MyEmployeeTest {

    @Autowired
    private MyEmployeeRepository myEmployeeRepository;
    @Autowired
    private Person3Repository personRepository;

    @Test
    void testGetCompany() {

    }

    @Test
    void testSetCompany() {

        myEmployeeRepository.deleteAll();

        MyEmployee emp = new MyEmployee(1, "john", "baeldung");
        myEmployeeRepository.save(emp);
        
        List<MyEmployee> employees = myEmployeeRepository.findAll();
        System.out.println("employees:"+employees.size());
        assertThat(employees).isNotEmpty();

        //List<Person3> persons = personRepository.findAll();
        //System.out.println("persons:"+persons.size());

    }
}
