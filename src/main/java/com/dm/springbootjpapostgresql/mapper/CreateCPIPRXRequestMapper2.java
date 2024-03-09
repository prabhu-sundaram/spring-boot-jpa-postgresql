package com.dm.springbootjpapostgresql.mapper;

import com.dm.springbootjpapostgresql.collection.montaji.CreateCPIPRXRequest;
import com.dm.springbootjpapostgresql.dto.montaji.CreateCPIPRXRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreateCPIPRXRequestMapper2 {
    @Mapping(target = "requestDetails.dtReferenceNo", source = "requestDetails.dtReferenceNo")
    @Mapping(target = "requestDetails.requestNumber", source = "requestDetails.requestNumber")
    @Mapping(target = "requestDetails.requestSource", source = "requestDetails.requestSource")
    @Mapping(target = "requestDetails.requestType", source = "requestDetails.requestType")
    @Mapping(target = "requestDetails.requestDate", source = "requestDetails.requestDate")
    @Mapping(target = "requestDetails.requestStatus", source = "requestDetails.requestStatus")
    @Mapping(target = "companyDetails.importerCode", source = "companyDetails.importerCode")
    @Mapping(target = "companyDetails.licensenumber", source = "companyDetails.licensenumber")
    CreateCPIPRXRequest mapToEntity(CreateCPIPRXRequestDTO dto);
}
