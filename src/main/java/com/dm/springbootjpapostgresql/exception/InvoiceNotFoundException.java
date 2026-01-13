package com.dm.springbootjpapostgresql.exception;

//Custom Exception
public class InvoiceNotFoundException extends RuntimeException{

	private static final Long serialVersionUID = 1L;

	public InvoiceNotFoundException() {
		super();
	}
	
	public InvoiceNotFoundException(String message) {
		super(message);
	}
	
}
