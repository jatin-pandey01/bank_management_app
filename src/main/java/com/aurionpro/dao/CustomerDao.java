package com.aurionpro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.aurionpro.model.Account;
import com.aurionpro.model.Customer;
import com.aurionpro.util.DbConnection;

public class CustomerDao {
	private Connection connection;
	private Statement statement = null;
	private ResultSet resultSet;
	
	public CustomerDao() {
		connection = DbConnection.getConnection();
	}
	
	private Statement getStatement() throws SQLException {
		if(statement == null) {
			statement = connection.createStatement();
		}
		return statement;
	}
	
	public boolean registerCustomer(Customer customer) {
		
		try {
			String sql = "insert into customers(first_name,last_name,gender,dob,email,mobile_number,aadhar_card,pan_card,password) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getLastName());
			preparedStatement.setString(3, customer.getGender());
			preparedStatement.setDate(4, customer.getDob());
			preparedStatement.setString(5, customer.getEmail());
			preparedStatement.setString(6, customer.getPhone());
			preparedStatement.setString(7, customer.getAadhar());
			preparedStatement.setString(8, customer.getPan());
			preparedStatement.setString(9, customer.getPassword());
			
			return preparedStatement.executeUpdate() > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public Customer loginCustomer(Customer customer) {
		
		try {
			statement = getStatement();
			resultSet = statement.executeQuery("select customer_id,first_name,last_name,gender,dob,email,mobile_number,aadhar_card,pan_card from customers where mobile_number = '" + customer.getPhone() + "' and password = '" + customer.getPassword() + "'");
			if(!resultSet.next()) {
				return null;
			}
			
			Customer cus = new Customer();
			cus.setCustomerId(resultSet.getInt(1));
			cus.setFirstName(resultSet.getString(2));
			cus.setLastName(resultSet.getString(3));
			cus.setGender(resultSet.getString(4));
			cus.setDob(resultSet.getDate(5));
			cus.setEmail(resultSet.getString(6));
			cus.setPhone(resultSet.getString(7));
			cus.setAadhar(resultSet.getString(8));
			cus.setPan(resultSet.getString(9));
			
			return cus;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Account> showAllAccount(int customerId) {
		
		try {
			System.out.println(customerId);
			statement = getStatement();
			resultSet = statement.executeQuery("select account_id, account_number, account_type, city, ifsc_code, balance, is_approved from accounts where customer_id = " + customerId);
			System.out.println("Line 91 : ");
			List<Account> accounts = new ArrayList<>();
			while(resultSet.next()) {
				System.out.println("Count ++ , ");
				accounts.add(new Account(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getString(5),
						resultSet.getDouble(6),
						resultSet.getBoolean(7)
				));
			}
			
			return accounts.size() <= 0 ? null : accounts ;
			
		} catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean createAccount(Account account) {
		
		try {
			String sql = "insert into accounts(customer_id,account_number,account_type,city,ifsc_code,balance) values(?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, account.getCustomerId());
			preparedStatement.setString(2, account.getAccountNumber());
			preparedStatement.setString(3, account.getAccountType());
			preparedStatement.setString(4, account.getCity());
			preparedStatement.setString(5, account.getIfscCode());
			preparedStatement.setDouble(6, account.getBalance());
			
			return preparedStatement.executeUpdate() > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}
