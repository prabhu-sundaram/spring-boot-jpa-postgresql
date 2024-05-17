package com.dm.springbootjpapostgresql.utils;

import java.sql.Clob;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.AttributeConverter;

@Component
public class StringToClobConverter implements AttributeConverter<String, Clob> {

    @Autowired
    private DataSource dataSource;

    @Override
    public Clob convertToDatabaseColumn(String attribute) {
        if (attribute == null) {
            return null;
        }
        try {
            Connection connection = dataSource.getConnection(); // Get connection from DataSource
            Clob clob = connection.createClob();
            clob.setString(1, attribute);
            connection.close(); // Close the connection (optional, managed by connection pool)
            return clob;
        } catch (SQLException e) {
            throw new RuntimeException("Error converting String to Clob", e);
        }
    }

    @Override
    public String convertToEntityAttribute(Clob dbData) {
        if (dbData == null) {
            return null;
        }
        try {
            return dbData.getSubString(1, (int) dbData.length());
        } catch (SQLException e) {
            // Handle the exception here (e.g., log the error, throw a runtime exception)
            throw new RuntimeException("Error converting Clob to String", e);
        }        
    }
}