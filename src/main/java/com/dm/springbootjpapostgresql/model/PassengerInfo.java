package com.dm.springbootjpapostgresql.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "passenger_info")

public class PassengerInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long pId;
    
    private String name;
    private String email;
    private String source;
    private String Destination;
    private Date travelDate;
    private String pickupTime;
    private String arrivalTime;
    private double fare;
    }