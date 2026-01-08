package com.dm.springbootjpapostgresql.model.document.montaji;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseObj{
    private String requestNumber;
    private String dtReferenceNo;
    private String requestType;
    private String status;
    private ArrayList<Payment> payment;
}
