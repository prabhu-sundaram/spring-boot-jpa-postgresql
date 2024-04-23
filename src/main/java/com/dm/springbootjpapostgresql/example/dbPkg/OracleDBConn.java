package com.dm.springbootjpapostgresql.example.dbPkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleDBConn {

	public static void main(String[] args) {

try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	String jdbcURL = "jdbc:oracle:thin:@localhost:1521:XE";
	String username = "spring";
	String password = "spring123";
	
	Connection con = DriverManager.getConnection(jdbcURL, username, password);
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery("select * from employee3");
	//ResultSet rs = st.executeQuery("select 1 from dual");
	
	while(rs.next())
	{
		System.out.println(rs.getInt(1)+":"+rs.getString(2)+":"+rs.getInt(3));
		//System.out.println(rs.getInt(1));
		
	}
	con.close();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	}

}

