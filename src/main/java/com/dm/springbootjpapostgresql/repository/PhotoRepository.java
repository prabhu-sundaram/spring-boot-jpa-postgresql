package com.dm.springbootjpapostgresql.repository;

import com.dm.springbootjpapostgresql.collection.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends MongoRepository<Photo, String> {
}
