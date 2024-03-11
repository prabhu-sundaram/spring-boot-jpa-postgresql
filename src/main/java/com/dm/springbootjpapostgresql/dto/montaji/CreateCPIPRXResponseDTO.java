package com.dm.springbootjpapostgresql.dto.montaji;

import lombok.Setter;

@Setter
public class CreateCPIPRXResponseDTO {
    private String isSuccess;
    private String errorCode;
    private String errorDescription;
    private DataObjDTO data;
    private ResponseDTO response;
}

