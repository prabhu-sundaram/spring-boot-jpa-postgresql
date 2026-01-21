package com.dm.springbootjpapostgresql.dto.montaji;

import java.time.LocalDate;
import java.util.List;

import com.dm.springbootjpapostgresql.model.entity.montaji.Address;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserFetchAllResponseDto {
    private Long userId;
	private String userName;
    private String userType;
    private String firstName;
    private String firstNameAr;
    private String lastName;    
    private String lastNameAr;
    private String fullName;    
    private String fullNameAr;    
    private String emailId;
    private String mobileNo;
    private boolean active;
    private String idType;
    private String idTypeName;
    private String idNumber;    
    private LocalDate idExpiryDate;
    private String gender;
    private Long nationalityId;  
    private String nationalityNameEn;
    private String nationalityNameAr;      
    private LocalDate dob;
    private Integer Age;
    private List<Address> addresses;
    private String licenseNumber;
    private String companyName;

}
