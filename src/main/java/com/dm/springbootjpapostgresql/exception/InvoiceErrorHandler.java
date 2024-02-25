package com.dm.springbootjpapostgresql.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dm.springbootjpapostgresql.model.ErrorType;
import com.dm.springbootjpapostgresql.exception.InvoiceNotFoundException;

//@ControllerAdvice
@RestControllerAdvice
public class InvoiceErrorHandler {
	/**
	 * In case of InvoiceNotFoundException is thrown
	 * from any controller method, this logic gets
	 * executed which behaves like re-usable and
	 * clear code (Code Modularity)
	 * @param nfe
	 * @return ResponseEntity
	 */
	//@ResponseBody
	@ExceptionHandler(InvoiceNotFoundException.class)
	public ResponseEntity<ErrorType> handleNotFound(InvoiceNotFoundException nfe){
		
		return new ResponseEntity<ErrorType>(
				new ErrorType(
						new Date(System.currentTimeMillis()).toString(), 
						"404- NOT FOUND", 
						nfe.getMessage()), 
				HttpStatus.NOT_FOUND);
	}
}
