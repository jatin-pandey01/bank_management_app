package com.aurionpro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aurionpro.model.Customer;
import com.aurionpro.service.CustomerService;

@WebServlet("/CustomerLoginController")
public class CustomerLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService customerService;
       
    public CustomerLoginController() {
        super();
        customerService = new CustomerService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone = request.getParameter("phoneTxt");
		String password = request.getParameter("passwordTxt");
		
		Customer customer = new Customer();
		customer.setPhone(phone);
		customer.setPassword(password);
		
		try {
			Customer cus = customerService.loginCustomer(customer);
			if(cus != null) {
				HttpSession session = request.getSession();
				session.setAttribute("customer", cus);
				response.sendRedirect("dashboard.jsp");
			}
			else {
				response.sendRedirect("login.jsp?error=Invalid credentials");
			}
		} catch (Exception e) {
			response.sendRedirect("error.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
