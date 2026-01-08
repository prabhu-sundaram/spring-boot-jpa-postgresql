package com.dm.springbootjpapostgresql.repository.jpa.montaji;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dm.springbootjpapostgresql.model.entity.montaji.ReqPortDetails;

@Repository
public interface ReqPortDetailsRepository extends JpaRepository<ReqPortDetails, Long> {
    
}
