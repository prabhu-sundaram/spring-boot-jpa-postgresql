package com.dm.springbootjpapostgresql.dto;

import com.dm.springbootjpapostgresql.model.entity.Country;
import com.dm.springbootjpapostgresql.model.entity.enumeration.Status;

import lombok.NoArgsConstructor;
import lombok.Getter;

@NoArgsConstructor
@Getter

public class CountryDTO {
    private String id;
    private String name;
    private Status status;

    public CountryDTO(Country country) {
        this.id = country.getId().toString();
        this.name = country.getName();
        this.status = country.getStatus();
    }
}
