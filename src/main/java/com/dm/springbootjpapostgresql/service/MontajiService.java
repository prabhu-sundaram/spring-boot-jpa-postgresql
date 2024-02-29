package com.dm.springbootjpapostgresql.service;

import com.dm.springbootjpapostgresql.collection.montaji.CreateCPIPRXRequest;
import com.dm.springbootjpapostgresql.dto.montaji.CreateCPIPRXRequestDTO;
import com.dm.springbootjpapostgresql.dto.montaji.CreateCPIPRXResponseDTO;


public interface MontajiService {

    CreateCPIPRXResponseDTO createCPIPRX(CreateCPIPRXRequestDTO createCPIPRXRequestDTO);
}
