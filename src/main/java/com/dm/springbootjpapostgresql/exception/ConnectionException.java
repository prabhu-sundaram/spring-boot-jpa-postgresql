package com.dm.springbootjpapostgresql.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConnectionException extends RuntimeException {

    private String message;
}
