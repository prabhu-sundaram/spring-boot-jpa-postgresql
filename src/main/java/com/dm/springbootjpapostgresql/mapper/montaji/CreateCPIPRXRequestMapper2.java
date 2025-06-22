package com.dm.springbootjpapostgresql.mapper.montaji;

import com.dm.springbootjpapostgresql.collection.montaji.CreateCPIPRXRequest;
import com.dm.springbootjpapostgresql.dto.montaji.CreateCPIPRXRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface CreateCPIPRXRequestMapper2 {

    @Mappings({
        @Mapping(source = "requestDetails", target = "requestDetails"),
        @Mapping(source = "companyDetails", target = "companyDetails"),
        @Mapping(source = "consignmentDetails", target = "consignmentDetails"),
        @Mapping(source = "containers", target = "containers"),
        @Mapping(source = "attachments", target = "attachments"),
        @Mapping(source = "preApproval", target = "preApproval")
    })        

    CreateCPIPRXRequest mapToEntity(CreateCPIPRXRequestDTO dto);
}

