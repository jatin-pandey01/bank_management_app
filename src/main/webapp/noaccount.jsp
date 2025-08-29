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
<title>No Account</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-yellow-100 min-h-screen px-5 py-5">

<div>
	<form action="dashboard.jsp"> 
		<button class="text-red-200 px-2 text-2xl font-bold bg-black"> < </button>
	</form>
</div>

<div class="h-(500px) flex flex-col justify-center items-center">
	<p> No Account found </p>
	<form action="accountcreation.jsp" method="get">
		<button> Create Account </button>
	</form>
</div>

</body>
</html>