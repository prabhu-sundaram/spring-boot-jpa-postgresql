package com.dm.springbootjpapostgresql.dto.montaji;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.sqm.internal.SqmInterpretationsKey;

import com.dm.springbootjpapostgresql.model.montaji.enumeration.Gender;
import com.dm.springbootjpapostgresql.model.montaji.enumeration.IdType;
import com.dm.springbootjpapostgresql.model.montaji.Address;
import com.dm.springbootjpapostgresql.model.montaji.Nationality;

import lombok.Getter;

@Getter
public class UserCreateRequestDto {
    
	private Long userId;
    private String userName;
    private int userType;
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
    private String idNumber;    
    private Date idExpiryDate;
    private String gender;
    private Long nationalityId;    
    private Date dob;
    private List<Address> addresses = new ArrayList<>();

}
