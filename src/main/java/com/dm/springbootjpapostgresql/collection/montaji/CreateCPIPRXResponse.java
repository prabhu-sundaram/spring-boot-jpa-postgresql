package com.dm.springbootjpapostgresql.collection.montaji;

import com.dm.springbootjpapostgresql.dto.montaji.DataObjDTO;
import com.dm.springbootjpapostgresql.dto.montaji.ResponseDTO;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
// import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.mongodb.core.mapping.Document;

//@Data
//@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "CreateCPIPRXResponse")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateCPIPRXResponse {
    public String isSuccess;
    public String errorCode;
    public String errorDescription;
    public DataObj data;
    public Response response;
}
