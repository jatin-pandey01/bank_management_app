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
<title>Create Account</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="bg-blue-50 min-h-screen flex items-center justify-center py-10">

	<div class="bg-white p-8 rounded-lg shadow-md w-full max-w-xl">
        <h2 class="text-2xl font-bold text-blue-700 mb-6 text-center">Open New Account</h2>

        <form action="CreateAccountController" method="post" class="space-y-4">
  
            <div>
                <label class="block mb-1 font-medium text-gray-700">Account Type</label>
                <select name="accountTypeTxt" required class="w-full border border-gray-300 rounded px-4 py-2">
                    <option value="">-- Select Account Type --</option>
                    <option value="Savings">Savings</option>
                    <option value="Current">Current</option>
                    <option value="Salary">Salary</option>
                </select>
            </div>

            
            <div>
                <label class="block mb-1 font-medium text-gray-700">City</label>
                <input type="text" name="cityTxt" required class="w-full border border-gray-300 rounded px-4 py-2">
            </div>

          
            <div>
                <label class="block mb-1 font-medium text-gray-700">Initial Balance</label>
                <input type="number" name="balanceTxt" min="0" required
                    class="w-full border border-gray-300 rounded px-4 py-2">
            </div>

            
            <div class="text-center mt-6">
                <button type="submit"
                    class="bg-blue-600 text-white px-6 py-2 rounded hover:bg-blue-700 transition duration-300">
                    Create Account
                </button>
            </div>
        </form>

        <div class="text-center mt-4">
            <a href="dashboard.jsp" class="text-blue-600 hover:underline text-sm">< Back to Dashboard</a>
        </div>
    </div>


</body>
</html>