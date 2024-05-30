package com.dm.springbootjpapostgresql.dto.montaji;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@Setter
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateCPIPRXResponseDTO {
    private String isSuccess;
    private String errorCode;
    private String errorDescription;
    private DataObjDTO data;
    private ResponseObjDTO response;
}

