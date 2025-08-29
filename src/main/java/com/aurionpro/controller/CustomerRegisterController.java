package com.aurionpro.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.model.Customer;
import com.aurionpro.service.CustomerService;

@WebServlet("/CustomerRegisterController")
public class CustomerRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService customerService;
       
    public CustomerRegisterController() {
        super();
        customerService = new CustomerService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstnameTxt");
		String lastName = request.getParameter("lastnameTxt");
		String gender = request.getParameter("genderTxt");
		Date dob = Date.valueOf(request.getParameter("dobTxt"));
		String email = request.getParameter("emailTxt");
		String phone = request.getParameter("phoneTxt");
		String aadhar = request.getParameter("aadharTxt");
		String pan = request.getParameter("panTxt");
		String password = request.getParameter("passwordTxt");
		
		Customer customer = new Customer(firstName, lastName, gender, dob, email, phone, aadhar, pan, password);
		
		try {
			if(customerService.registerCustomer(customer)) {
				response.sendRedirect("login.jsp");
			}
			else {
				response.sendRedirect("error.jsp");
			}
		} catch (Exception e) {
			response.sendRedirect("error.jsp");
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
