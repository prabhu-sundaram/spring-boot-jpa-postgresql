package com.dm.springbootjpapostgresql.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dm.springbootjpapostgresql.model.montaji.CompanyDetails;
import com.dm.springbootjpapostgresql.repository.montaji.CompanyDetailsRepository;

@SpringBootTest 
public class CompanyDetailsRepositoryTest {

    @Autowired
    CompanyDetailsRepository companyDetailsRepository;

    @Test
    public void saveCompanyDetails()
    {
    CompanyDetails companyDetails=CompanyDetails.builder()
                                                .licenseNumber("208061")
                                                .importerCode("AE-123456")
                                                .companyName("Test company")
                                                .licenseAuthorityId("DED")
                                                .licenseExpiryDate("1/1/2030")
                                                .contactEmail("test@gmail.com")
                                                .contactMobile("0551234567")
                                                .contactPhone("04233456")
                                                .contactFax("23423")
                                                .build();

    companyDetailsRepository.save(companyDetails);

    CompanyDetails companyDetails2=CompanyDetails.builder()
                                                .licenseNumber("1000")
                                                .importerCode("AE-5678")
                                                .companyName("Test company 2")
                                                .licenseAuthorityId("DED")
                                                .licenseExpiryDate("1/1/2030")
                                                .contactEmail("test@gmail.com")
                                                .contactMobile("0551234567")
                                                .contactPhone("04233456")
                                                .contactFax("23423")
                                                .build();

    companyDetailsRepository.save(companyDetails2);

    }

    @Test
    public void getAllCompanies()
    {
        List<CompanyDetails> companies =   companyDetailsRepository.findAll();
        System.out.println("companies:"+companies);


    }

}
