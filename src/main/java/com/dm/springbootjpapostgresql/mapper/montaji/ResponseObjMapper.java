package com.dm.springbootjpapostgresql.mapper.montaji;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.dm.springbootjpapostgresql.collection.montaji.ResponseObj;
import com.dm.springbootjpapostgresql.dto.montaji.ResponseObjDTO;

@Mapper(componentModel = "spring")
public interface ResponseObjMapper {
    //ResponseObjMapper INSTANCE = Mappers.getMapper(ResponseObjMapper.class);

    ResponseObjDTO toDTO(ResponseObj entity);
}
