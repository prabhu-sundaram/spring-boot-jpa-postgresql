package com.dm.springbootjpapostgresql.service;

import com.dm.springbootjpapostgresql.collection.Person2;
import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService {
    String save(Person2 person);

    List<Person2> getPersonStartWith(String name);

    void delete(String id);

    List<Person2> getByPersonAge(Integer minAge, Integer maxAge);

    Page<Person2> search(String name, Integer minAge, Integer maxAge, String city, Pageable pageable);

    List<Document> getOldestPersonByCity();

    List<Document> getPopulationByCity();
}
