package com.dm.springbootjpapostgresql.mapper.montaji;

import com.dm.springbootjpapostgresql.collection.montaji.CreateCPIPRXRequest;
import com.dm.springbootjpapostgresql.dto.montaji.CreateCPIPRXRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreateCPIPRXRequestMapper2 {
    CreateCPIPRXRequest mapToEntity(CreateCPIPRXRequestDTO dto);
}
