package com.aurionpro.util;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	private static Connection connection = null;
	
	public static Connection getConnection() {
		ConfigReader config = new ConfigReader("config.properties");
		if(connection == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(config.get("db.url"),config.get("db.user"),config.get("db.password"));
				System.out.println("Connection successfully.");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
}
