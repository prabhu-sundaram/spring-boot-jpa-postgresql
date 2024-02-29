package com.dm.springbootjpapostgresql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dm.springbootjpapostgresql.collection.montaji.CreateCPIPRXRequest;
import com.dm.springbootjpapostgresql.collection.montaji.CreateCPIPRXResponse;
import com.dm.springbootjpapostgresql.dto.montaji.CreateCPIPRXRequestDTO;
import com.dm.springbootjpapostgresql.dto.montaji.CreateCPIPRXResponseDTO;
import com.dm.springbootjpapostgresql.dto.montaji.Response;
import com.dm.springbootjpapostgresql.mapper.CommentMapper;
import com.dm.springbootjpapostgresql.mapper.CreateCPIPRXRequestMapper;
import com.dm.springbootjpapostgresql.mapper.CreateCPIPRXResponseMapper;
import com.dm.springbootjpapostgresql.model.Comment;
import com.dm.springbootjpapostgresql.repository.CreateCPIPRXRequestRepository;
import com.dm.springbootjpapostgresql.repository.CreateCPIPRXResponseRepository;
import com.dm.springbootjpapostgresql.service.MontajiService;

@Service
public class MontajiServiceImpl implements MontajiService{

@Autowired
private CreateCPIPRXRequestMapper createCPIPRXRequestMapper;
@Autowired
private CreateCPIPRXResponseMapper createCPIPRXResponseMapper;

@Autowired
CreateCPIPRXRequestRepository createCPIPRXRequestRepository;
@Autowired
CreateCPIPRXResponseRepository createCPIPRXResponseRepository;

    @Override
    public CreateCPIPRXResponseDTO createCPIPRX(CreateCPIPRXRequestDTO createCPIPRXRequestDTO) {
        CreateCPIPRXRequest createCPIPRXRequest = createCPIPRXRequestMapper.mapToEntity(createCPIPRXRequestDTO);
        createCPIPRXRequestRepository.save(createCPIPRXRequest);

        CreateCPIPRXResponse createCPIPRXResponse = new CreateCPIPRXResponse();
        createCPIPRXResponse.isSuccess="true";
        createCPIPRXResponse.errorCode="000";
        createCPIPRXResponse.errorDescription="No Error";
        createCPIPRXResponse.data=null;
        Response response = new Response();
        response.requestNumber="CPIP-221221-009434";
        response.dtReferenceNo="DTREF005690351";
        createCPIPRXResponse.setResponse(response);
        
        createCPIPRXResponseRepository.save(createCPIPRXResponse);        

        return createCPIPRXResponseMapper.mapToDTO(createCPIPRXResponse);        
    }
    
}
