package com.dm.springbootjpapostgresql.dto.montaji;

import java.util.ArrayList;

import lombok.Setter;

@Setter
public class ResponseDTO{
    private String requestNumber;
    private String dtReferenceNo;
    private String requestType;
    private String status;
    private ArrayList<PaymentDTO> payment;
}
