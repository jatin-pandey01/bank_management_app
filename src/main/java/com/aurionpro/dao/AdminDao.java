package com.aurionpro.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.aurionpro.model.Account;
import com.aurionpro.util.DbConnection;

public class AdminDao {
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	
	public AdminDao() {
		connection = DbConnection.getConnection();
	}
	
	private Statement getStatement() throws SQLException {
		if(statement == null) {
			statement = connection.createStatement();
		}
		return statement;
	}
	
	public List<Account> showAllPendingAccount() {
		
		try {
			statement = getStatement();
			resultSet = statement.executeQuery("select customer_id, account_id, account_number, account_type, city, ifsc_code, balance, is_approved from accounts where is_approved = false");
			List<Account> accounts = new ArrayList<>();
			while(resultSet.next()) {
				System.out.println("Count ++ , ");
				accounts.add(new Account(
						resultSet.getInt(1),
						resultSet.getInt(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getString(5),
						resultSet.getString(6),
						resultSet.getDouble(7),
						resultSet.getBoolean(8)
				));
			}
			
			return accounts.size() <= 0 ? null : accounts ;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
