package com.dm.springbootjpapostgresql.collection.montaji;

import java.util.ArrayList;

import lombok.Setter;

@Setter
public class Response{
    private String requestNumber;
    private String dtReferenceNo;
    private String requestType;
    private String status;
    private ArrayList<Payment> payment;
}
