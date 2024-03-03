package com.dm.springbootjpapostgresql.dto.montaji;

import java.util.ArrayList;

public class ResponseDTO{
    public String requestNumber;
    public String dtReferenceNo;
    public String requestType;
    public String status;
    public ArrayList<PaymentDTO> payment;
}
