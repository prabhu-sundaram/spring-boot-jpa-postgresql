package com.dm.springbootjpapostgresql.model.Administration;

import jakarta.persistence.*;

@Entity
@Table(name = "nationality")
public class Nationality {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nationality_id")    
    private Long nationalityId;

    @Column(name = "name_en")
    private String nationalityNameEn;

    @Column(name = "name_ar")
    private String nationalityNameAr;

    public String getNationalityNameAr() {
        return nationalityNameAr;
    }

    public void setNationalityNameAr(String nationalityNameAr) {
        this.nationalityNameAr = nationalityNameAr;
    }

    public String getNationalityNameEn() {
        return nationalityNameEn;
    }

    public void setNationalityNameEn(String nationalityNameEn) {
        this.nationalityNameEn = nationalityNameEn;
    }

    // Constructor
    public Nationality(Long nationalityId, String nationalityNameEn, String nationalityNameAr) {
        this.nationalityId = nationalityId;
        this.nationalityNameEn = nationalityNameEn;
        this.nationalityNameAr = nationalityNameAr;
    }

    // Getters and Setters
    public Long getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(Long nationalityId) {
        this.nationalityId = nationalityId;
    }



    // toString method to represent object as string
    @Override
    public String toString() {
        return "Nationality{" +
                "nationalityId=" + nationalityId +
                ", nationalityNameEn='" + nationalityNameEn + '\'' +
                ", nationalityNameAr='" + nationalityNameAr + '\'' +
                '}';
    }
}

