package com.dm.springbootjpapostgresql.example.dbPkg;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.dm.springbootjpapostgresql.example.beans.Employee2;

public class JDBCExample2 {

    public static void main(String[] args) {

        System.out.println("Oracle JDBC Connection Testing ~");

        List<Employee2> result = new ArrayList<>();

        String SQL_SELECT = "Select * from EMPLOYEE2";

        // auto close connection and preparedStatement
        try (Connection conn = DriverManager.getConnection(
        		"jdbc:oracle:thin:@localhost:1521:ORCL", "user1", "user1");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {

            ResultSet resultSet = preparedStatement.executeQuery();

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

                result.add(obj);

            }
            result.forEach(x -> System.out.println(x));

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
