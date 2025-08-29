package com.aurionpro.model;

public class Account {
	private int customerId, accountId;
	private String accountNumber, accountType, city, ifscCode;
	private double balance;
	private boolean status;
	
	public Account() {
		super();
	}

	public Account(int accountId,String accountNumber, String accountType, String city, String ifscCode, double balance, boolean status) {
		super();
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.city = city;
		this.ifscCode = ifscCode;
		this.balance = balance;
		this.status = status;
	}

	public Account(int customerId, int accountId, String accountNumber, String accountType, String city, String ifscCode,
			double balance, boolean status) {
		super();
		this.customerId = customerId;
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.city = city;
		this.ifscCode = ifscCode;
		this.balance = balance;
		this.status = status;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
