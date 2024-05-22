package com.dm.springbootjpapostgresql.dto.montaji;

import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;

@Setter
@Builder
@Getter
@JsonInclude(JsonInclude.Include.ALWAYS)
public class UserCreateResponseDto {
    private String isSuccess;
    private String errorCode;
    private String errorDescription;
}
