package com.dm.springbootjpapostgresql.example.dbPkg.preparestatement.table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TableDrop {

    private static final String SQL_DROP = "DROP TABLE EMPLOYEE2";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
        		"jdbc:oracle:thin:@localhost:1521:XE", "spring", "spring123");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_DROP)) {

            preparedStatement.execute();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}