package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static final String URL= "jdbc:postgresql://localhost:5432/postgres";
	public static final String USERNAME= "postgres";
	public static final String PASSWORD = "password";

	public static Connection createConnection() throws SQLException {
		return DriverManager.getConnection(URL,USERNAME,PASSWORD);
	}
}
