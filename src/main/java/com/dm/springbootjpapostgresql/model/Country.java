package com.dm.springbootjpapostgresql.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.dm.springbootjpapostgresql.model.enumeration.Status;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Builder
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private BigDecimal id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",columnDefinition = "varchar(255) default 'Active'")
    //private Status status = Status.Active;
    private Status status;
   
    public Country(BigDecimal id, String name, Status status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }    
}
