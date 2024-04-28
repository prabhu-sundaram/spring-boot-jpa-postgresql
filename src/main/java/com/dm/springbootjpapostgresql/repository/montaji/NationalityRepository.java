package com.dm.springbootjpapostgresql.repository.montaji;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dm.springbootjpapostgresql.model.montaji.Nationality;

@Repository
public interface NationalityRepository extends JpaRepository<Nationality, Long> {
    // Add custom query methods if needed
}
