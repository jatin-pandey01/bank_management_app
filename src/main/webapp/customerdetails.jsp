<%@page import="com.aurionpro.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
    Customer customer = (Customer) session.getAttribute("customer");
    if (customer == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Personal Detail</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-yellow-100 min-h-screen pt-5">

<% 
	HttpSession sess = request.getSession(); 
	customer = (Customer) sess.getAttribute("customer");
%>

<div class="w-full flex justify-center items-center" >
	<p class="text-3xl font-bold text-green-400"> Personal Detail </p>
</div>

<div class="px-10">
	<div class="flex items-center text-lg my-5"> 
		<p> First Name : </p>
		<p class="bg-green-100 px-5 mx-5 rounded-xl"> <%= customer.getFirstName() %> </p>
	</div>
	
	<div class="flex items-center text-lg mb-5"> 
		<p> Last Name : </p>
		<p class="bg-green-100 px-5 mx-5 rounded-xl"> <%= customer.getLastName() %> </p>
	</div>
	
	<div class="flex items-center text-lg mb-5"> 
		<p> Gender : </p>
		<p class="bg-green-100 px-5 mx-5 rounded-xl"> <%= customer.getGender() %> </p>
	</div>
	
	<div class="flex items-center text-lg mb-5"> 
		<p> Date of Birth : </p>
		<p class="bg-green-100 px-5 mx-5 rounded-xl"> <%= customer.getDob() %> </p>
	</div>
	
	<div class="flex items-center text-lg mb-5"> 
		<p> Email : </p>
		<p class="bg-green-100 px-5 mx-5 rounded-xl"> <%= customer.getEmail() %> </p>
	</div>
	
	<div class="flex items-center text-lg mb-5"> 
		<p> Mobile Number : </p>
		<p class="bg-green-100 px-5 mx-5 rounded-xl"> <%= customer.getPhone() %> </p>
	</div>
	
	<div class="flex items-center text-lg mb-5"> 
		<p> Aadhar Number : </p>
		<p class="bg-green-100 px-5 mx-5 rounded-xl"> <%= customer.getAadhar() %> </p>
	</div>
	
	<div class="flex items-center text-lg mb-5"> 
		<p> PAN Number : </p>
		<p class="bg-green-100 px-5 mx-5 rounded-xl"> <%= customer.getPan() %> </p>
	</div>
	
	<form action="dashboard.jsp" method="get" class="flex justify-center text-2xl">
		<button class="border bg-green-600 text-white px-5 text-2xl rounded-xl"> < Back </button>
	</form>
	
</div>

</body>
</html>