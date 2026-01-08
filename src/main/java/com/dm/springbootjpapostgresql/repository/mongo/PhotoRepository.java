package com.dm.springbootjpapostgresql.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dm.springbootjpapostgresql.model.document.Photo;

@Repository
public interface PhotoRepository extends MongoRepository<Photo, String> {
}
