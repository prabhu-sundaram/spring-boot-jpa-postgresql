package com.dm.springbootjpapostgresql.example.dbPkg;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.dm.springbootjpapostgresql.config.DatabaseProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCExample {

	public void testDBConn(DatabaseProperties databaseProperties) {
        // https://docs.oracle.com/javase/8/docs/api/java/sql/package-summary.html#package.description
        // auto java.sql.Driver discovery -- no longer need to load a java.sql.Driver class via Class.forName

        // register JDBC driver, optional since java 1.6
        /*try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        //https://stackoverflow.com/questions/18192521/ora-12505-tnslistener-does-not-currently-know-of-sid-given-in-connect-descript
        //jdbc:oracle:thin:@myserver:1521/XE

        String jdbcUrl = databaseProperties.getUrl();
        String username = databaseProperties.getUsername();
        String password = databaseProperties.getPassword();

        // auto close connection
        try (Connection conn = DriverManager.getConnection(
        	jdbcUrl, username, password)) {

            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}
