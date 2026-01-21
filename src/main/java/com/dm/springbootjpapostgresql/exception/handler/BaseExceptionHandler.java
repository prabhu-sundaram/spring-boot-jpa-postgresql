package com.dm.springbootjpapostgresql.exception.handler;

import java.time.Instant;
import java.util.Date;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dm.springbootjpapostgresql.exception.BaseException;
import com.dm.springbootjpapostgresql.exception.BlogAPIException;
import com.dm.springbootjpapostgresql.exception.ErrorResponseDto;
import com.dm.springbootjpapostgresql.exception.ErrorType;
import com.dm.springbootjpapostgresql.exception.InvoiceNotFoundException;
import com.dm.springbootjpapostgresql.exception.MontajiExceptionDto;
import com.dm.springbootjpapostgresql.exception.ResourceNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
@Order(1)
public class BaseExceptionHandler {

@ExceptionHandler(BaseException.class)  
    public ResponseEntity<MontajiExceptionDto> handleBaseException(BaseException ex) {
        log.error("Exception occurred: Code: {}, Message: {}", ex.getErrorCode(), ex.getMessage());

        MontajiExceptionDto montajiExceptionDto = MontajiExceptionDto.builder()
                                                                    .timestamp(Instant.now())
                                                                    .isSuccess("false")
                                                                    .errorCode(ex.getErrorCode())
                                                                    .errorDescription(ex.getMessage())
                                                                    .build();
        return new ResponseEntity<>(montajiExceptionDto, ex.getStatus());

    }

    @ExceptionHandler(BlogAPIException.class)
    public ResponseEntity<ErrorResponseDto> handleNotFoundException(BlogAPIException ex) {
        log.error("Inside BlogAPIException Exception: ", ex);

        ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .timestamp(Instant.now())
                .message(ex.getMessage())
                .status(ex.getStatus())
                .build();
        return new ResponseEntity<>(errorResponse, ex.getStatus());
    }  
    
	@ExceptionHandler(InvoiceNotFoundException.class)
	public ResponseEntity<ErrorType> handleNotFound(InvoiceNotFoundException nfe){
		
		return new ResponseEntity<ErrorType>(
				new ErrorType(
						new Date(System.currentTimeMillis()).toString(), 
						"404- NOT FOUND", 
						nfe.getMessage()), 
				HttpStatus.NOT_FOUND);
	}
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleNotFoundException(ResourceNotFoundException ex) {
        log.error("Inside ResourceNotFoundException Exception: ", ex);

        ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .timestamp(Instant.now())
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }      
}
