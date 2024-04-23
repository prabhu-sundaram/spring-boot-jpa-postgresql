package com.dm.springbootjpapostgresql.example.dbPkg.statement.row;

import com.dm.springbootjpapostgresql.example.beans.Employee2;

import java.math.BigDecimal;
import java.sql.*;

public class RowSelect {

    public static void main(String[] args) {

        String sql = "SELECT * FROM EMPLOYEE3";

        try (Connection conn = DriverManager.getConnection(
        		"jdbc:oracle:thin:@localhost:1521:XE", "spring", "spring123");
             Statement statement = conn.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                long id = resultSet.getLong("ID");
                String name = resultSet.getString("NAME");
                BigDecimal salary = resultSet.getBigDecimal("SALARY");
                Timestamp createdDate = resultSet.getTimestamp("CREATED_DATE");

                Employee2 obj = new Employee2();
                obj.setId(id);
                obj.setName(name);
                obj.setSalary(salary);
                // Timestamp -> LocalDateTime
                obj.setCreatedDate(createdDate.toLocalDateTime());

                System.out.println(obj);
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}