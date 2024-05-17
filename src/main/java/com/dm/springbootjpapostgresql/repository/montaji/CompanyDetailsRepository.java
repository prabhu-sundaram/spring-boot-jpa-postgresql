package com.dm.springbootjpapostgresql.repository.montaji;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dm.springbootjpapostgresql.model.montaji.CompanyDetails;

@Repository
public interface CompanyDetailsRepository extends JpaRepository<CompanyDetails, String> {
    Optional<CompanyDetails> findByImporterCode(String importerCode);
    Optional<CompanyDetails> findByLicenseNumber(String licenseNumber);

}
