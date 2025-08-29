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

@WebServlet("/CreateAccountController")
public class CreateAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService customerService;
   
    public CreateAccountController() {
        super();
        customerService = new CustomerService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountType = request.getParameter("accountTypeTxt");
		String city = request.getParameter("cityTxt");
		double balance = Double.parseDouble(request.getParameter("balanceTxt"));
		
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		List<Account> accounts = (List<Account>) session.getAttribute("accounts");
		int number = 0;
		if(accounts != null) {
			number = accounts.size();
		}
		Account account = new Account();
		account.setCustomerId(customer.getCustomerId());
		String accountNumber = "09560151" + String.valueOf(customer.getCustomerId() + number);
		account.setAccountNumber(accountNumber);
		account.setAccountType(accountType);
		String ifsc = "BI" + accountType.charAt(0) + city.charAt(0) + "000" + String.valueOf(customer.getCustomerId() + number) ;
		
		account.setIfscCode(ifsc);
		account.setBalance(balance);
		account.setCity(city);
		
		if(customerService.createAccount(account)) {
			response.sendRedirect("CustomerAccounts");
		}
		else {
			response.sendRedirect("error.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
