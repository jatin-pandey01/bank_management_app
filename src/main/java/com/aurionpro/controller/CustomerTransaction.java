package com.aurionpro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aurionpro.model.Account;
import com.aurionpro.model.Customer;
import com.aurionpro.service.CustomerService;

@WebServlet("/CustomerTransaction")
public class CustomerTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService customerService; 
       
    public CustomerTransaction() {
        super();
        customerService = new CustomerService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		
		List<Account> accounts = customerService.showAllAccount(customer.getCustomerId());
		
		if(accounts == null) {
			response.sendRedirect("noaccount.jsp");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
