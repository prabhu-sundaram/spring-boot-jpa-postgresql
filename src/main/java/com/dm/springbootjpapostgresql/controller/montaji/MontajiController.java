package com.dm.springbootjpapostgresql.controller.montaji;

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
        //CreateCPIPRXResponseDTO createCPIPRXErrorResponseDTO = new CreateCPIPRXResponseDTO();

        try {
            CreateCPIPRXResponseDTO createCPIPRXResponseDTO = montajiService.createCPIPRX(createCPIPRXRequestDTO);
            System.out.println("After calling montajiService.createCPIPRX");
            //return new ResponseEntity<>(createCPIPRXResponseDTO, HttpStatus.OK);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(createCPIPRXResponseDTO);        
            } catch (AttachmentValidationException e) {
                // createCPIPRXErrorResponseDTO.setIsSuccess("false");
                // createCPIPRXErrorResponseDTO.setErrorCode("201");
                // createCPIPRXErrorResponseDTO.setErrorDescription("Validation error: " + e.getMessage());
                // createCPIPRXErrorResponseDTO.setData(null);
                // createCPIPRXErrorResponseDTO.setResponse(null);     
                
                CreateCPIPRXResponseDTO createCPIPRXErrorResponseDTO=CreateCPIPRXResponseDTO.builder()
                                                                                            .isSuccess("false")
                                                                                            .errorCode("201")
                                                                                            .errorDescription("Validation error: " + e.getMessage())
                                                                                            .data(null)
                                                                                            .response(null)
                                                                                            .build();
                return ResponseEntity
                        .badRequest()
                        .body(createCPIPRXErrorResponseDTO);
            } catch (IOException e) {
                // createCPIPRXErrorResponseDTO.setIsSuccess("false");
                // createCPIPRXErrorResponseDTO.setErrorCode("202");
                // createCPIPRXErrorResponseDTO.setErrorDescription("IO Exception: " + e.getMessage());
                // createCPIPRXErrorResponseDTO.setData(null);
                // createCPIPRXErrorResponseDTO.setResponse(null);    
                CreateCPIPRXResponseDTO createCPIPRXErrorResponseDTO=CreateCPIPRXResponseDTO.builder()
                                                                                            .isSuccess("false")
                                                                                            .errorCode("202")
                                                                                            .errorDescription("IO Exception: " + e.getMessage())
                                                                                            .data(null)
                                                                                            .response(null)
                                                                                            .build();                              
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(createCPIPRXErrorResponseDTO);         
            } catch (Exception e) {
                // createCPIPRXErrorResponseDTO.setIsSuccess("false");
                // createCPIPRXErrorResponseDTO.setErrorCode("999");
                // createCPIPRXErrorResponseDTO.setErrorDescription("Error creating CPIPRX: " + e.getMessage());
                // createCPIPRXErrorResponseDTO.setData(null);
                // createCPIPRXErrorResponseDTO.setResponse(null);      
                CreateCPIPRXResponseDTO createCPIPRXErrorResponseDTO=CreateCPIPRXResponseDTO.builder()
                                                                                            .isSuccess("false")
                                                                                            .errorCode("999")
                                                                                            .errorDescription("Error creating CPIPRX: " + e.getMessage())
                                                                                            .data(null)
                                                                                            .response(null)
                                                                                            .build();                              
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(createCPIPRXErrorResponseDTO);  
            }
    }   

    @PostMapping("/CreateCPIPRXMongo")
    public ResponseEntity<Object> createCPIPRXMongo(@RequestBody CreateCPIPRXRequestDTO createCPIPRXRequestDTO) {
 
        CreateCPIPRXResponseDTO createCPIPRXResponseDTO = montajiService.createCPIPRXMongo(createCPIPRXRequestDTO);
        
        return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(createCPIPRXResponseDTO);     
    }

}
