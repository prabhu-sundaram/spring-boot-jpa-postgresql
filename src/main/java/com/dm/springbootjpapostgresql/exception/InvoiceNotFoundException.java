package com.dm.springbootjpapostgresql.exception;

//Custom Exception
public class InvoiceNotFoundException extends RuntimeException{

	public InvoiceNotFoundException() {
		super();
	}
	
	public InvoiceNotFoundException(String message) {
		super(message);
	}
	
}
