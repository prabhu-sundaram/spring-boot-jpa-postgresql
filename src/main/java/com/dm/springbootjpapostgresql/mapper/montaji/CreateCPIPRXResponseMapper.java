package com.dm.springbootjpapostgresql.mapper.montaji;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dm.springbootjpapostgresql.collection.montaji.CreateCPIPRXResponse;
import com.dm.springbootjpapostgresql.dto.montaji.CreateCPIPRXResponseDTO;

@Component
public class CreateCPIPRXResponseMapper {
 
    @Autowired
    private ModelMapper modelMapper;

    // convert Entity into DTO
    public CreateCPIPRXResponseDTO mapToDTO(CreateCPIPRXResponse createCPIPRXResponse){
        CreateCPIPRXResponseDTO createCPIPRXResponseDTO = modelMapper.map(createCPIPRXResponse, CreateCPIPRXResponseDTO.class);

        return createCPIPRXResponseDTO;
    }

    // convert DTO to entity
    // public CreateCPIPRXResponse mapToEntity(CreateCPIPRXResponseDTO createCPIPRXResponseDTO){
    //     CreateCPIPRXResponse createCPIPRXResponse = modelMapper.map(createCPIPRXResponseDTO, CreateCPIPRXResponse.class);
    //     return createCPIPRXResponse;
    // }

}
