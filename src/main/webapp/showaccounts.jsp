<%@page import="java.util.List"%>
<%@page import="com.aurionpro.model.Customer"%>
<%@page import="com.aurionpro.model.Account"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    Customer customer = (Customer) session.getAttribute("customer");
    if (customer == null) {
        response.sendRedirect("login.jsp");
        return;
    }
    
    List<Account> accounts = (List<Account>) session.getAttribute("accounts");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-50 min-h-screen p-6">

	<div>
	<form action="dashboard.jsp"> 
		<button class="text-red-200 px-2 text-2xl font-bold bg-black"> < </button>
	</form>
</div>

    <div class="max-w-6xl mx-auto bg-white shadow-md rounded-lg p-8">
        <h1 class="text-3xl font-bold text-gray-800 mb-4">Hello, <%= customer.getFirstName() %></h1>

        <h2 class="text-xl font-semibold text-gray-700 mb-2">Your Bank Accounts</h2>

        <div class="overflow-x-auto">
            <table class="min-w-full bg-white border border-gray-300 rounded">
                <thead class="bg-gray-100">
                    <tr>
                        <th class="py-2 px-4 text-left border-b">Account Number</th>
                        <th class="py-2 px-4 text-left border-b">Account Type</th>
                        <th class="py-2 px-4 text-left border-b">City</th>
                        <th class="py-2 px-4 text-left border-b">IFSC Code</th>
                        <th class="py-2 px-4 text-left border-b">Balance (₹)</th>
                        <th class="py-2 px-4 text-left border-b">Status</th>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${not empty accounts}">
                            <c:forEach var="account" items="${accounts}">
                                <tr class="border-t hover:bg-gray-50">
                                    <td class="py-2 px-4">${account.getAccountNumber()}</td>
                                    <td class="py-2 px-4">${account.getAccountType()}</td>
                                    <td class="py-2 px-4">${account.getCity()}</td>
                                    <td class="py-2 px-4">${account.getIfscCode()}</td>
                                    <td class="py-2 px-4 font-medium">₹${account.getBalance()}</td>
                                    <td class="py-2 px-4"> 
                                    <c:choose>
 										<c:when test="${account.getStatus() }">
											<p class="text-green-600">Active </p>
  										</c:when>
  										<c:otherwise>
   											<p class="text-red-600">Pending </p>
  										</c:otherwise>
									</c:choose>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td colspan="5" class="py-4 px-4 text-center text-gray-500">No accounts found</td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>
        </div>

        <div class="mt-6 flex justify-between items-center">
            <a href="accountcreation.jsp" class="text-blue-600 hover:underline font-medium">+ Create New Account</a>
            <form action="logout.jsp">
                <button class="bg-red-500 text-white px-4 py-2 rounded hover:bg-red-600">Logout</button>
            </form>
        </div>
    </div>

</body>
</html>
