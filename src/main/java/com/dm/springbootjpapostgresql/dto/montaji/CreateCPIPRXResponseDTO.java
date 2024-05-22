package com.dm.springbootjpapostgresql.dto.montaji;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.ALWAYS)
public class CreateCPIPRXResponseDTO {
    private String isSuccess;
    private String errorCode;
    private String errorDescription;
    private DataObjDTO data;
    private ResponseDTO response;
}

