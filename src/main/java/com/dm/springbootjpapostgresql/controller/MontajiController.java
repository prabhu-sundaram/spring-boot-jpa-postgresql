package com.dm.springbootjpapostgresql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.dm.springbootjpapostgresql.dto.montaji.CreateCPIPRXRequestDTO;
import com.dm.springbootjpapostgresql.dto.montaji.CreateCPIPRXResponseDTO;

import com.dm.springbootjpapostgresql.service.MontajiService;

@RestController
@RequestMapping("/api/Montaji")
public class MontajiController {

    @Autowired
    private MontajiService montajiService;

    @PostMapping("/CreateCPIPRX")
    public ResponseEntity<CreateCPIPRXResponseDTO> createCPIPRX(@RequestBody CreateCPIPRXRequestDTO createCPIPRXRequestDTO) {

        CreateCPIPRXResponseDTO createCPIPRXResponseDTO = montajiService.createCPIPRX(createCPIPRXRequestDTO);
        System.out.println("After calling montajiService.createCPIPRX");
        try {
            return new ResponseEntity<>(createCPIPRXResponseDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }   
}
