package com.dm.springbootjpapostgresql.dto;

import com.dm.springbootjpapostgresql.model.PassengerInfo;
import com.dm.springbootjpapostgresql.model.PaymentInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class FlightBookingRequest {
    
    private PassengerInfo passengerInfo;
    private PaymentInfo paymentInfo;
}
