package com.dm.springbootjpapostgresql.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class ProcedureExecutorService {

    private final JdbcTemplate jdbcTemplate;

    @Transactional
    public <T> T executeProcedure(String procedureCall, CallableStatementCallback<T> action) {
        return jdbcTemplate.execute(procedureCall, action);
    }

}
