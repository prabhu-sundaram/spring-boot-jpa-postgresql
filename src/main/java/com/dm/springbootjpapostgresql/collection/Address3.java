package com.dm.springbootjpapostgresql.collection;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address3 {

    private String address1;
    private String address2;
    private String city;
}
