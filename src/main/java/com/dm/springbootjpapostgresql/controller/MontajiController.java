package com.dm.springbootjpapostgresql.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.dm.springbootjpapostgresql.dto.montaji.CreateCPIPRXRequestDTO;
import com.dm.springbootjpapostgresql.dto.montaji.CreateCPIPRXResponseDTO;
import com.dm.springbootjpapostgresql.exception.AttachmentValidationException;
import com.dm.springbootjpapostgresql.service.MontajiService;

@RestController
@RequestMapping("/api/Montaji")
public class MontajiController {

    @Autowired
    private MontajiService montajiService;

    @PostMapping("/CreateCPIPRX")
    public ResponseEntity<Object> createCPIPRX(@RequestBody CreateCPIPRXRequestDTO createCPIPRXRequestDTO) {
        System.out.println("Inside CreateCPIPRX controller");
        CreateCPIPRXResponseDTO createCPIPRXErrorResponseDTO = new CreateCPIPRXResponseDTO();

        try {
            CreateCPIPRXResponseDTO createCPIPRXResponseDTO = montajiService.createCPIPRX(createCPIPRXRequestDTO);
            System.out.println("After calling montajiService.createCPIPRX");
            return new ResponseEntity<>(createCPIPRXResponseDTO, HttpStatus.OK);
            } catch (AttachmentValidationException e) {
                createCPIPRXErrorResponseDTO.setIsSuccess("false");
                createCPIPRXErrorResponseDTO.setErrorCode("001");
                createCPIPRXErrorResponseDTO.setErrorDescription("Validation error: " + e.getMessage());
                createCPIPRXErrorResponseDTO.setData(null);
                createCPIPRXErrorResponseDTO.setResponse(null);                
                return ResponseEntity.badRequest().body(createCPIPRXErrorResponseDTO);
            } catch (IOException e) {
                createCPIPRXErrorResponseDTO.setIsSuccess("false");
                createCPIPRXErrorResponseDTO.setErrorCode("002");
                createCPIPRXErrorResponseDTO.setErrorDescription("IO Exception: " + e.getMessage());
                createCPIPRXErrorResponseDTO.setData(null);
                createCPIPRXErrorResponseDTO.setResponse(null);                  
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(createCPIPRXErrorResponseDTO);         
            } catch (Exception e) {
                createCPIPRXErrorResponseDTO.setIsSuccess("false");
                createCPIPRXErrorResponseDTO.setErrorCode("999");
                createCPIPRXErrorResponseDTO.setErrorDescription("Error creating CPIPRX: " + e.getMessage());
                createCPIPRXErrorResponseDTO.setData(null);
                createCPIPRXErrorResponseDTO.setResponse(null);                  
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(createCPIPRXErrorResponseDTO);  
            }
    }   
}
