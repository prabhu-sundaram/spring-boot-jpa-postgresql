package com.dm.springbootjpapostgresql.model;

import org.hibernate.annotations.GenericGenerator;

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
@Table(name = "payment_info")

public class PaymentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String paymentId;
    
    private String accountNo;
    private double amount;
    private String cardType;
    private Long passengerId;
    }