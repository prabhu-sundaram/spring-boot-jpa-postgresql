package com.dm.springbootjpapostgresql.service;

import java.io.IOException;

import com.dm.springbootjpapostgresql.collection.montaji.CreateCPIPRXRequest;
import com.dm.springbootjpapostgresql.dto.montaji.CreateCPIPRXRequestDTO;
import com.dm.springbootjpapostgresql.dto.montaji.CreateCPIPRXResponseDTO;
import com.dm.springbootjpapostgresql.exception.AttachmentValidationException;


public interface MontajiService {

    CreateCPIPRXResponseDTO createCPIPRX(CreateCPIPRXRequestDTO createCPIPRXRequestDTO) throws AttachmentValidationException, IOException;
}
