package com.dm.springbootjpapostgresql.repository.jpa.montaji;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dm.springbootjpapostgresql.model.entity.montaji.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    // Add custom query methods if needed
}

