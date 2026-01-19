package com.dm.springbootjpapostgresql.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.dm.springbootjpapostgresql.exception.MappingException;
import com.dm.springbootjpapostgresql.exception.StoredProcedureException;
import com.dm.springbootjpapostgresql.utils.ProcedureExecutorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Collections;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProcedureExecutionHelper {

    private final ProcedureExecutorService procedureExecutorService;
    private final ObjectMapper mapper;

    public String executeProcedure(String procedure, String request) {
        try {
            return runProcedure(procedure, request);
        } catch (Exception e) {
            log.error("Error while executing procedure: {}", procedure, e);
            throw new StoredProcedureException("Exception while calling stored procedure: " + procedure, e);
        }
    }

    public <T> T executeProcedure(String procedure, String request, Class<T> responseType) {
        try {
            String response = runProcedure(procedure, request);
            return toObject(response, responseType);
        } catch (MappingException ex) {
            log.error("Failed to parse JSON response for procedure: {}", procedure, ex);
            throw new MappingException("Error while processing JSON.", ex);
        } catch (Exception e) {
            log.error("Error while executing procedure: {}", procedure, e);
            throw new RuntimeException("Exception while calling stored procedure: " + procedure, e);
        }
    }

    public String executeRefCursorProcedure(String procedure, String request) {
        try {
             return runRefCursorProcedure(procedure, request);
        } catch (MappingException ex) {
            log.error("Failed to parse JSON response for procedure: {}", procedure, ex);
            throw new MappingException("Error while processing JSON.", ex);
        } catch (Exception e) {
            log.error("Error while executing procedure: {}", procedure, e);
            throw new RuntimeException("Exception while calling stored procedure: " + procedure, e);
        }
    }

    public <T> List<T> executeProcedureForList(String procedure, String request, Class<T> responseType) {
        try {
            String response = runProcedure(procedure, request);
            if (response == null || response.trim().isEmpty()) {
                log.warn("Procedure {} returned empty response. Returning empty list.", procedure);
                return Collections.emptyList();
            }
            return toList(response, responseType);
        } catch (MappingException ex) {
            log.error("Failed to parse JSON response for procedure: {}", procedure, ex);
            throw new MappingException("Error while processing JSON.", ex);
        } catch (Exception e) {
            log.error("Error while executing procedure: {}", procedure, e);
            throw new StoredProcedureException("Exception while calling stored procedure: " + procedure, e);
        }
    }

    private String runProcedure(String procedure, String data) {
        return procedureExecutorService.executeProcedure(procedure, stmt -> {
            stmt.setString(1, data);
            stmt.registerOutParameter(2, Types.CLOB);
            stmt.execute();
            Clob outputClob = stmt.getClob(2);
            String response = (outputClob != null) ? outputClob.getSubString(1, (int) outputClob.length()) : null;
            log.info("Response from procedure name: {} response: {}", procedure, response);
            return response;
        });
    }

    private String runRefCursorProcedure(String procedure, String data) {
        return procedureExecutorService.executeProcedure(procedure, stmt -> {
            stmt.setString(1, data);
            stmt.registerOutParameter(2, Types.REF_CURSOR);
            stmt.execute();

            String response = null;
            try (ResultSet rs = (ResultSet) stmt.getObject(2)) {
                if (rs != null && rs.next()) {
                    // Assuming the cursor returns a single column with the response
                    response = rs.getString(1);
                }
            }

            log.info("Response from procedure name: {} response: {}", procedure, response);
            return response;
        });
    }

    private <T> T toObject(String data, Class<T> clazz) {
        try {
            return mapper.readValue(data, clazz);
        } catch (Exception e) {
            log.error("Failed to parse JSON response into {}", clazz.getSimpleName());
            throw new MappingException("Error while processing JSON.", e);
        }
    }

    private <T> List<T> toList(String data, Class<T> clazz) {
        try {
            return mapper.readValue(data, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (Exception e) {
            log.error("Failed to parse JSON response into List of {}", clazz.getSimpleName(), e);
            throw new MappingException("Error while processing JSON.", e);
        }
    }
}

