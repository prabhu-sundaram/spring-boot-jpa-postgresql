package com.dm.springbootjpapostgresql.dto.montaji;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseObjDTO{
    private String requestNumber;
    private String dtReferenceNo;
    private String requestType;
    private String status;
    private ArrayList<PaymentDTO> payment;
}
