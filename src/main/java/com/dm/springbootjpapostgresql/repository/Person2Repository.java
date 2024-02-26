package com.dm.springbootjpapostgresql.repository;

import com.dm.springbootjpapostgresql.collection.Person2;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Person2Repository extends MongoRepository<Person2,String> {

    List<Person2> findByFirstNameStartsWith(String name);

    //List<Person> findByAgeBetween(Integer min, Integer max);

    @Query(value = "{ 'age' : { $gt : ?0, $lt : ?1}}",
           fields = "{addresses:  0}")
    List<Person2> findPersonByAgeBetween(Integer min, Integer max);
}
