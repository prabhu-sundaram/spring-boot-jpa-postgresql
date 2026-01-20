package com.dm.springbootjpapostgresql.exception.handler;

import java.time.Instant;

import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dm.springbootjpapostgresql.exception.BlogAPIException;
import com.dm.springbootjpapostgresql.exception.ErrorResponseDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
@Order(1)
public class BlogAPIExceptionHandler {
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
}
