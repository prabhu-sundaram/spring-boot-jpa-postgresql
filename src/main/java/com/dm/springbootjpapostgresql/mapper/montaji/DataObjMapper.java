package com.dm.springbootjpapostgresql.mapper.montaji;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.dm.springbootjpapostgresql.collection.montaji.DataObj;
import com.dm.springbootjpapostgresql.dto.montaji.DataObjDTO;

@Mapper(componentModel = "spring")
public interface DataObjMapper {
    //DataObjMapper INSTANCE = Mappers.getMapper(DataObjMapper.class);

    DataObjDTO toDTO(DataObj entity);
}
