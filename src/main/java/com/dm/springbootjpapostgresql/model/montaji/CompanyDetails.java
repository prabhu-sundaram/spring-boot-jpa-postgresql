package com.dm.springbootjpapostgresql.model.montaji;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "company_details"
    ,uniqueConstraints = {
                     @UniqueConstraint(columnNames = "license_number")
                    })
public class CompanyDetails {
    @Id
    @Column(name = "license_number", nullable = false)
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

    @OneToMany(mappedBy = "companyDetails", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Request> requests;


}
