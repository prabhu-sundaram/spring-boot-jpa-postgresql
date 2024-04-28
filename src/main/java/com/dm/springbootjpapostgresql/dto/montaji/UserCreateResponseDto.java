package com.dm.springbootjpapostgresql.dto.montaji;

import lombok.Setter;
import lombok.Builder;

@Setter
@Builder
public class UserCreateResponseDto {
    private String isSuccess;
    private String errorCode;
    private String errorDescription;
}
