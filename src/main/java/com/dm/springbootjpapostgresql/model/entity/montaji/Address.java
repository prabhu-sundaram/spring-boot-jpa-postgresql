package com.dm.springbootjpapostgresql.model.entity.montaji;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
	private Long addressId;

    @Column(name = "address_type")
    private AddressType addressType;

    @Column(name = "flat")
    private String flat;

    @Column(name = "floor")
    private String floor;

    @Column(name = "building")
    private String building;

    @Column(name = "street")
    private String street;

    @Column(name = "community")
    private String community;

    @Column(name = "emirate")
    private String emirate;

    @Column(name = "country")
    private String country;

    @Column(name = "makani")
    private String makani;

    @Column(name = "po_box")
    private String poBox;

    @Column(name = "fax")
    private String fax;

    //@Column(name = "active",columnDefinition = "boolean default true")
    @Column(name = "active")
    private boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    /* 
    // Constructor
    public Address(Long addressId, AddressType addressType, String flat, String floor, String building,
                   String street, String community, String emirate, String country,
                   String makani, String poBox, String fax, Boolean active) {
        this.addressId = addressId;
        this.addressType = addressType;
        this.flat = flat;
        this.floor = floor;
        this.building = building;
        this.street = street;
        this.community = community;
        this.emirate = emirate;
        this.country = country;
        this.makani = makani;
        this.poBox = poBox;
        this.fax = fax;
        this.active = active;
    }

    // Getters and Setters for each field

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getEmirate() {
        return emirate;
    }

    public void setEmirate(String emirate) {
        this.emirate = emirate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMakani() {
        return makani;
    }

    public void setMakani(String makani) {
        this.makani = makani;
    }

    public String getPoBox() {
        return poBox;
    }

    public void setPoBox(String poBox) {
        this.poBox = poBox;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    // toString method to represent object as string
    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", addressType='" + addressType + '\'' +
                ", flat='" + flat + '\'' +
                ", floor='" + floor + '\'' +
                ", building='" + building + '\'' +
                ", street='" + street + '\'' +
                ", community='" + community + '\'' +
                ", emirate='" + emirate + '\'' +
                ", country='" + country + '\'' +
                ", makani='" + makani + '\'' +
                ", poBox='" + poBox + '\'' +
                ", fax='" + fax + '\'' +
                ", active='" + active + '\'' +
                '}';
    }*/
}

enum AddressType {
    RESIDENCE,
    OFFICE,
    OTHER
}

