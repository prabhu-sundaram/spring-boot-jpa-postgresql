package com.dm.springbootjpapostgresql.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.dm.springbootjpapostgresql.model.document.Person2;

import java.util.List;

@Repository
public interface Person2Repository extends MongoRepository<Person2,String> {

    List<Person2> findByFirstNameStartsWith(String name);

    //List<Person> findByAgeBetween(Integer min, Integer max);

    @Query(value = "{ 'age' : { $gt : ?0, $lt : ?1}}",
           fields = "{addresses:  0}")
    List<Person2> findPersonByAgeBetween(Integer min, Integer max);
}
