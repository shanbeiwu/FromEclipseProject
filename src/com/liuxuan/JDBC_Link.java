package com.liuxuan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class JDBC_Link {
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/water";
	private static Connection conn = null;
	
	static {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConn(){
		return conn;
	}
	public static void main(String[] args) {
		getConn();
	}
}
