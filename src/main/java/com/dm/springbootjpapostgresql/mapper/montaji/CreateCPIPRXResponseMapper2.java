package com.dm.springbootjpapostgresql.mapper.montaji;

import com.dm.springbootjpapostgresql.collection.montaji.CreateCPIPRXResponse;
import com.dm.springbootjpapostgresql.collection.montaji.DataObj;
import com.dm.springbootjpapostgresql.collection.montaji.ResponseObj;
import com.dm.springbootjpapostgresql.dto.montaji.CreateCPIPRXResponseDTO;
import com.dm.springbootjpapostgresql.dto.montaji.DataObjDTO;
import com.dm.springbootjpapostgresql.dto.montaji.ResponseObjDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CreateCPIPRXResponseMapper2 {

    //CreateCPIPRXResponseMapper2 INSTANCE = Mappers.getMapper(CreateCPIPRXResponseMapper2.class);

    @Mappings({
        @Mapping(source = "data", target = "data"),
        @Mapping(source = "response", target = "response")
    })
    CreateCPIPRXResponseDTO mapToDTO(CreateCPIPRXResponse createCPIPRXResponse);
    
    DataObjDTO dataObjToDataObjDTO(DataObj dataObj);
    ResponseObjDTO responseObjToResponseObjDTO(ResponseObj responseObj);    
}
