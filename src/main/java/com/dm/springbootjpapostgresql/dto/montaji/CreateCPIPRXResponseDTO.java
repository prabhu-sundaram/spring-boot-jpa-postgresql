package com.dm.springbootjpapostgresql.dto.montaji;

import lombok.Setter;

@Setter
public class CreateCPIPRXResponseDTO {
    public String isSuccess;
    public String errorCode;
    public String errorDescription;
    public DataObjDTO data;
    public ResponseDTO response;
}

