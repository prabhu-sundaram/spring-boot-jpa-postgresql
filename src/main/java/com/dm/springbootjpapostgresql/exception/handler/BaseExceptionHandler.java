package com.dm.springbootjpapostgresql.exception.handler;

import java.time.Instant;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dm.springbootjpapostgresql.exception.BaseException;
import com.dm.springbootjpapostgresql.exception.ErrorResponseDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
@Order(1)
public class BaseExceptionHandler {

@ExceptionHandler(BaseException.class)
public ResponseEntity<ErrorResponseDto> handleBaseException(BaseException ex) {
    ErrorResponseDto error = ErrorResponseDto.builder()
            .timestamp(Instant.now())
            .message(ex.getMessage())
            //.errorCode(ex.getErrorCode()) // Now every exception has a code!
            .status(HttpStatus.BAD_REQUEST)
            .build();
            
    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
}    
    
}
