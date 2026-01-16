package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility {

	private static DBUtility instance;
	private static final String URL = "jdbc:mysql://localhost:3306/jpa8081";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	private DBUtility() {

	}

	public static DBUtility getInstance() {
		if (instance == null) {
			instance = new DBUtility();
		}
		return instance;
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			System.out.println("Database Connection Issue " + e);
		}
		return con;
	}
}
