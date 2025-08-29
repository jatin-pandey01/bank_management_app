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

@WebServlet("/CustomerAccounts")
public class CustomerAccounts extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CustomerService customerService;
    
    public CustomerAccounts() {
        super();
        customerService = new CustomerService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		
		System.out.println("Customer Id : " + customer.getCustomerId());
		List<Account> accounts = customerService.showAllAccount(customer.getCustomerId());
		
		if(accounts == null) {
			response.sendRedirect("noaccount.jsp");
		}
		else {
			System.out.println(accounts.size());
			session.setAttribute("accounts", accounts);
			response.sendRedirect("showaccounts.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
