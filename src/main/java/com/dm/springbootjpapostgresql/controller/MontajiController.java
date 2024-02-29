package com.dm.springbootjpapostgresql.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public CreateCPIPRXResponseDTO createCPIPRX(@RequestBody CreateCPIPRXRequestDTO createCPIPRXRequestDTO) {
        return montajiService.createCPIPRX(createCPIPRXRequestDTO);
    }   
}
