package com.aurionpro.service;

import java.util.List;

import com.aurionpro.dao.CustomerDao;
import com.aurionpro.model.Account;
import com.aurionpro.model.Customer;

public class CustomerService {
	private CustomerDao customerDao;
	
	public CustomerService() {
		customerDao = new CustomerDao();
	}
	
	public boolean registerCustomer(Customer customer) {
		return customerDao.registerCustomer(customer);
	}
	
	public Customer loginCustomer(Customer customer) {
		return customerDao.loginCustomer(customer);
	}
	
	public List<Account> showAllAccount(int customerId) {
		return  customerDao.showAllAccount(customerId);
	}
	
	public boolean createAccount(Account account) {
		return customerDao.createAccount(account);
	}
	
}
