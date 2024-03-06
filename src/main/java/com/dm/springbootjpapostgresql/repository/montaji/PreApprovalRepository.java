package com.dm.springbootjpapostgresql.repository.montaji;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dm.springbootjpapostgresql.model.montaji.PreApproval;

@Repository
public interface PreApprovalRepository extends JpaRepository<PreApproval, Long> {
    
}
