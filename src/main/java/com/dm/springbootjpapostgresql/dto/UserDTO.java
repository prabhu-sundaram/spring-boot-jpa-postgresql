package com.dm.springbootjpapostgresql.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.dm.springbootjpapostgresql.model.Administration.Nationality;
import com.dm.springbootjpapostgresql.model.enumeration.Gender;
import com.dm.springbootjpapostgresql.model.enumeration.IdType;

import com.dm.springbootjpapostgresql.model.Address;

import lombok.Data;

@Data
public class UserDTO {
    
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
    private Boolean active;
    private IdType idType;
    private String idNumber;    
    private Date idExpiryDate;
    private Gender  gender;
    private Nationality nationality;
    private Date dob;
    private List<Address> addresses = new ArrayList<>();

}
