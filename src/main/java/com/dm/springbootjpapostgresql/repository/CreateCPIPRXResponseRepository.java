package com.dm.springbootjpapostgresql.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dm.springbootjpapostgresql.collection.montaji.CreateCPIPRXResponse;

@Repository
public interface CreateCPIPRXResponseRepository extends MongoRepository<CreateCPIPRXResponse,String> {

}
