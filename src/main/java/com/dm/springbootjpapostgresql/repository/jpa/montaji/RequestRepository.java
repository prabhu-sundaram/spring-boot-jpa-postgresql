package com.dm.springbootjpapostgresql.repository.jpa.montaji;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dm.springbootjpapostgresql.model.entity.montaji.Request;
import com.dm.springbootjpapostgresql.model.entity.montaji.User;

@Repository
public interface RequestRepository extends JpaRepository<Request, String> {
    //Optional<Request> findByDtReferenceNo(String dtReferenceNo);
    List<Request> findByDtReferenceNo(String dtReferenceNo);
}
