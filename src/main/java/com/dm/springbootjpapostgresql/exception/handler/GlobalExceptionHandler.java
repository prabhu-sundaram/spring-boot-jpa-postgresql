package com.dm.springbootjpapostgresql.exception.handler;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dm.springbootjpapostgresql.exception.ErrorResponseDto;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Hidden
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Map<String, String>> handleMissingParams(MissingServletRequestParameterException ex) {
        log.error("Inside MissingServletRequestParameterException: ", ex);

        Map<String, String> error = new HashMap<>();
        error.put("error", "Bad Request");
        error.put("message", ex.getParameterName() + " parameter is missing");

        return ResponseEntity.badRequest().body(error); // 400
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgument(IllegalArgumentException ex) {
        log.error("Inside IllegalArgumentException: ", ex);

        return ResponseEntity.badRequest()
                .body(Map.of("error", ex.getMessage()));
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleValidationExceptions(MethodArgumentNotValidException ex) {
        log.error("Inside MethodArgumentNotValidException: ", ex);

        // String errorMessage = ex.getBindingResult().getFieldErrors().stream()
        //         .map(error -> error.getField() + ": " + error.getDefaultMessage())
        //         .collect(Collectors.joining(", "));
        // if (errorMessage.isEmpty()){
        //     errorMessage = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        // }

        // ErrorResponseDto errorResponse = ErrorResponseDto.builder()
        //         .timestamp(Instant.now())
        //         .message(errorMessage)
        //         .status(HttpStatus.BAD_REQUEST)
        //         .build();

        // return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

        Map<String, String> errors = new HashMap<>();
        
        // Extract each error message and the field it belongs to
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .timestamp(Instant.now())
                .message("Validation Failed")
                .status(HttpStatus.BAD_REQUEST)
                // You can add an 'errors' field to your Dto if you want to send the Map
                .build();

        // Alternatively, return just the 'errors' map for a cleaner API
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);        
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleNotFoundException(NotFoundException ex) {
        log.error("NotFound Exception: ", ex);

        ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .timestamp(Instant.now())
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Catch database-specific errors (Oracle Procedure Failures)
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ErrorResponseDto> handleDatabaseError(DataAccessException ex) {
        log.error("Inside DataAccessException: ", ex);

        // ErrorResponseDto errorResponse = new ErrorResponseDto(
        //     Instant.now(),
        //     HttpStatus.INTERNAL_SERVER_ERROR,
        //     "Database Error: " + ex.getMostSpecificCause().getMessage()
        // );
        // return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    String msg = ex.getMostSpecificCause().getMessage();
    
    // ORA-01403 is "No Data Found" in Oracle
    if (msg.contains("ORA-01403")) {
        return new ResponseEntity<>(
            new ErrorResponseDto(Instant.now(),
            HttpStatus.NOT_FOUND,
            "Record not found"
        ),HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(
        new ErrorResponseDto(Instant.now(), 
        HttpStatus.INTERNAL_SERVER_ERROR,
        "DB Error: " + msg),HttpStatus.INTERNAL_SERVER_ERROR);        
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponseDto> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        log.error("Inside handleDataIntegrityViolationException: ", ex);

        ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .timestamp(Instant.now())
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponseDto> handleRuntimeExceptions(RuntimeException ex) {
        log.error("Inside Runtime Exception: ", ex);

        ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .timestamp(Instant.now())
                .message(ex.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // @ExceptionHandler(Exception.class)
    // public ResponseEntity<Map<String, String>> handleGenericException(Exception ex) {

    //     Map<String, String> error = new HashMap<>();
    //     error.put("error", "Internal Server Error");
    //     error.put("message", "Something went wrong");

    //     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error); // 500
    // }

    // Catch Generic errors
    // @ExceptionHandler(Exception.class)
    // public ResponseEntity<ErrorResponseDto> handleGeneralError(Exception ex) {
    //     ErrorResponseDto errorResponse = new ErrorResponseDto(
    //         Instant.now(),
    //         HttpStatus.INTERNAL_SERVER_ERROR,
    //         "An unexpected error occurred: " + ex.getMessage()            
    //     );
    //     return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    // }    

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // Sets the status code automatically    
    public ErrorResponseDto handleGeneralError(Exception ex) {
        log.error("Inside Generic Exception: ", ex);

        // No need for ResponseEntity wrapper; @RestControllerAdvice handles serialization
        return ErrorResponseDto.builder()
                .timestamp(Instant.now())
                .message(ex.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
    }    



}

