package com.dm.springbootjpapostgresql.model.montaji;

import java.util.ArrayList;
import java.util.List;

import com.dm.springbootjpapostgresql.model.Post;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company_details"
    ,uniqueConstraints = {
                     @UniqueConstraint(columnNames = "license_number")
                    })
public class CompanyDetails {
    @Id
    private String licenseNumber;
    private String companyName;
    private String importerCode;
    private String licenseAuthorityId;
    private String licenseAuthorityname;
    private String licenseExpiryDate;
    private String contactFax;
    private String contactMobile;
    private String contactEmail;
    private String contactPhone;

    @OneToMany(mappedBy = "license_number", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Request> requests;


}
