package com.dm.springbootjpapostgresql.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dm.springbootjpapostgresql.collection.montaji.CreateCPIPRXRequest;
import com.dm.springbootjpapostgresql.dto.montaji.CreateCPIPRXRequestDTO;

@Component
public class CreateCPIPRXRequestMapper {
 
    @Autowired
    private ModelMapper modelMapper;

    // convert Entity into DTO
    public CreateCPIPRXRequestDTO mapToDTO(CreateCPIPRXRequest createCPIPRXRequest){
        CreateCPIPRXRequestDTO createCPIPRXRequestDTO = modelMapper.map(createCPIPRXRequest, CreateCPIPRXRequestDTO.class);
        return createCPIPRXRequestDTO;
    }

    // convert DTO to entity
    public CreateCPIPRXRequest mapToEntity(CreateCPIPRXRequestDTO createCPIPRXRequestDTO){
        CreateCPIPRXRequest createCPIPRXRequest = modelMapper.map(createCPIPRXRequestDTO, CreateCPIPRXRequest.class);
        return createCPIPRXRequest;
    }

}
