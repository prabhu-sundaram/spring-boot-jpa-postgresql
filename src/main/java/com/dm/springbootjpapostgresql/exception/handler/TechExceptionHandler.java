package com.dm.springbootjpapostgresql.exception.handler;

import java.time.Instant;

import org.hibernate.tool.schema.spi.SqlScriptException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dm.springbootjpapostgresql.exception.BadRequestException;
import com.dm.springbootjpapostgresql.exception.ConnectionException;
import com.dm.springbootjpapostgresql.exception.ErrorResponseDto;
import com.dm.springbootjpapostgresql.exception.InternalServerErrorException;
import com.dm.springbootjpapostgresql.exception.MappingException;
import com.dm.springbootjpapostgresql.exception.StoredProcedureException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
@Order(1)
public class TechExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponseDto> handleBadRequestException(BadRequestException ex) {
        log.error("BadRequest Exception: ", ex);

        ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .timestamp(Instant.now())
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<ErrorResponseDto> handleInternalServerErrorException(InternalServerErrorException ex) {
        log.error("InternalServer Exception: ", ex);

        ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .timestamp(Instant.now())
                .message(ex.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MappingException.class)
    public ResponseEntity<ErrorResponseDto> handleMappingException(MappingException ex) {
        log.error("Mapping Exception: ", ex);

        ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .timestamp(Instant.now())
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConnectionException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // Sets the status code automatically
    public ErrorResponseDto handleConnectionException(ConnectionException ex) {
        log.error("JDBC closure issue: ", ex);
        
        // No need for ResponseEntity wrapper; @RestControllerAdvice handles serialization
        return ErrorResponseDto.builder()
                .timestamp(Instant.now())
                .message(ex.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
    }

    @ExceptionHandler(StoredProcedureException.class)
    public ResponseEntity<ErrorResponseDto> handleStoredProcedureException(StoredProcedureException ex) {
        log.error("Stored procedure error response: ", ex);

        ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .timestamp(Instant.now())
                .message(ex.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
 
    @ExceptionHandler(SqlScriptException.class)
    public ResponseEntity<ErrorResponseDto> handleSqlScriptException(SqlScriptException ex) {
        log.error("Unable to load sql script Exception: ", ex);

        ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .timestamp(Instant.now())
                .message(ex.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }    
}
