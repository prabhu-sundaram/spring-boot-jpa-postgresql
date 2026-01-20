package com.dm.springbootjpapostgresql.exception.handler;

import java.time.Instant;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dm.springbootjpapostgresql.exception.AttachmentValidationException;
import com.dm.springbootjpapostgresql.exception.ErrorResponseDto;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
@Order(1)
public class MontajiExceptionHandler {

    @ExceptionHandler(AttachmentValidationException.class)
    public ResponseEntity<ErrorResponseDto> handleBadRequestException(AttachmentValidationException ex) {
        log.error("AttachmentValidationException Exception: ", ex);

        ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .timestamp(Instant.now())
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
  
}
