<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.aurionpro.model.Customer"%>
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
<title>Dashboard</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-beige-50 min-h-screen pt-5">

<div class="w-full flex justify-center items-center ">
	<p class="text-black text-3xl font-bold"> Welcome to Bank of India </p>
</div>
	
<div>

<div class="h-96 flex justify-around items-center w-full "> 
	<form action="customerdetails.jsp" method="get">
		<button class="text-xl px-4 py-2 bg-green-400 rounded-xl text-white font-medium"> Personal Details </button>
	</form>
	
	<form action="CustomerAccounts">
		<button class="text-xl px-4 py-2 bg-green-400 rounded-xl text-white font-medium"> Show All Accounts </button>
	</form>
	
	<form action="customertransactions.jsp" method="get">
		<button class="text-xl px-4 py-2 bg-green-400 rounded-xl text-white font-medium"> Transactions History </button>
	</form>
	
	<form action="logout.jsp">
    	<button class="bg-red-500 text-white px-4 py-2 rounded hover:bg-red-600">Logout</button>
    </form>
</div>


</div>


</body>
</html>