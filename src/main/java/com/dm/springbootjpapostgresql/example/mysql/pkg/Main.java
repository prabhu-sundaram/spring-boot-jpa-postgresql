package com.dm.springbootjpapostgresql.example.mysql.pkg;

public class Main {
    public static void main(String[] args) throws Exception {
        MySQLAccess dao = new MySQLAccess();
        dao.readDataBase();
    }
}
    