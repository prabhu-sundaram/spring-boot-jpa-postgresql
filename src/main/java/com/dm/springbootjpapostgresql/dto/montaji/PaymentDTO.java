package com.dm.springbootjpapostgresql.dto.montaji;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PaymentDTO{
    private String vouchernumber;
    private String voucherStatus;
}