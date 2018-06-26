package com.liuxuan.pilianginsert;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlLink {
	private String driver = "";
	private String url = "";
	private String username = "";
	private String password = "";
	private static MysqlLink connection = null;
	
	private MysqlLink() throws Exception {
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/day12";
		username = "root";
		password = "root";
	}
	
	public static Connection getconn() {
		Connection conn = null;
		if (connection == null) {
			try {
				connection = new MysqlLink();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		try {
			Class.forName(connection.driver);
			conn = DriverManager.getConnection(connection.url, connection.username, 
					connection.password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void main(String[] args) {
		MysqlLink.getconn();
	}
}
