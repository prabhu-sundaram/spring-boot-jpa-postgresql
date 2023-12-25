package com.dm.springbootjpapostgresql.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dm.springbootjpapostgresql.model.Administration.Nationality;
import jakarta.persistence.*;

@Entity
@Table(name = "user",uniqueConstraints = {
        @UniqueConstraint(columnNames = "user_id")
})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
	private Long userId;
    
    @Column(name = "user_name",length=20,nullable=false)
    private String userName;
    @Column(name = "user_type")
    private String userType;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "first_name_ar")
    private String firstNameAr;
    @Column(name = "last_name")
    private String lastName;    
    @Column(name = "last_name_ar")
    private String lastNameAr;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "mobile_no")
    private String mobileNo;
    @Column(name = "active",columnDefinition = "boolean default true")
    private Boolean active;
    @Column(name = "id_type")
    private IdType idType;
    @Column(name = "id_number")
    private String idNumber;    
    @Column(name = "id_expiry_date")
    private Date idExpiryDate;
    @Column(name = "gender")
    private Gender  gender;
    @Column(name = "nationality")
    private Nationality nationality; // Reference to Nationality class
    @Column(name = "dob")
    private Date dob;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user",fetch = FetchType.LAZY)
    //private List<Address> addresses;
    private List<Address> addresses = new ArrayList<>();

    // Constructor
    public User(Long userId, String userName, String userType, String firstName, String firstNameAr, String lastName, String lastNameAr, String emailId,
                      String mobileNo, Boolean active, IdType idType, String idNumber, Date idExpiryDate, Gender gender,
                      Nationality nationality, Date dob) {
        this.userId = userId;
        this.userName = userName;
        this.userType = userType;
        this.firstName = firstName;
        this.firstNameAr = firstNameAr;        
        this.lastName = lastName;
        this.lastNameAr = lastNameAr;
        this.emailId = emailId;
        this.mobileNo = mobileNo;
        this.active = active;
        this.idType = idType;
        this.idNumber = idNumber;
        this.idExpiryDate = idExpiryDate;
        this.gender = gender;
        this.nationality = nationality;
        this.dob = dob;
    }

    // Getters and Setters for each field
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstNameAr() {
        return firstNameAr;
    }
    public void setFirstNameAr(String firstNameAr) {
        this.firstNameAr = firstNameAr;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastNameAr() {
        return lastNameAr;
    }    

    public void setLastNameAr(String lastNameAr) {
        this.lastNameAr = lastNameAr;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public IdType getIdType() {
        return idType;
    }

    public void setIdType(IdType idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Date getIdExpiryDate() {
        return idExpiryDate;
    }

    public void setIdExpiryDate(Date idExpiryDate) {
        this.idExpiryDate = idExpiryDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Nationality  getNationality() {
        return nationality;
    }

    public void setNationality(Nationality  nationality) {
        this.nationality = nationality;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    // toString method to represent object as string
    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userType='" + userType + '\'' +
                ", firstName='" + firstName + '\'' +
                ", firstNameAr='" + firstNameAr + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lastNameAr='" + lastNameAr + '\'' +
                ", emailId='" + emailId + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", active='" + active + '\'' +
                ", idType='" + idType + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", idExpiryDate='" + idExpiryDate + '\'' +
                ", gender='" + gender + '\'' +
                ", nationality='" + nationality + '\'' +
                ", dob=" + dob +
                '}';
    }
}

// Enum for Gender
enum Gender {
    MALE,
    FEMALE,
    OTHER
}

enum IdType {
    PASSPORT,
    VISA,
    OTHER
}
