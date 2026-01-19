package com.dm.springbootjpapostgresql.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SqlScriptException extends RuntimeException {

    public SqlScriptException(String message) {
        super(message   );
    }
}
