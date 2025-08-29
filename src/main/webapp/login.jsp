<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
		HttpSession sess = request.getSession(false);
		if(sess.getAttribute("customer") != null){
			response.sendRedirect("dashboard.jsp");
			return;
		}
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gradient-to-r from-purple-200 to-indigo-100 min-h-screen flex items-center justify-center">
	
	
    <div class="bg-white p-10 rounded-lg shadow-lg w-full max-w-md">
        <h2 class="text-2xl font-bold text-center mb-6 text-indigo-600">Customer Login</h2>
        <form action="CustomerLoginController" method="post" class="space-y-4">
            <div>
                <label class="block font-medium mb-1">Mobile number</label>
                <input type="text" name="phoneTxt" class="w-full border border-gray-300 rounded px-4 py-2" placeholder="Mobile" required>
            </div>
            <div>
                <label class="block font-medium mb-1">Password</label>
                <input type="password" name="passwordTxt" class="w-full border border-gray-300 rounded px-4 py-2" placeholder="Password" required>
            </div>
            <button type="submit" class="w-full bg-indigo-600 text-white py-2 rounded hover:bg-indigo-700 transition">
                Login
            </button>
            <p class="text-center mt-4 text-sm">Don’t have an account? <a href="register.jsp" class="text-indigo-600 font-medium hover:underline">Register</a></p>
			<p class="text-center"><a href="adminlogin.jsp" class="text-blue-600 hover:underline font-medium"> Admin Login </a></p>
            <% if(request.getParameter("error") != null) { %>
                <p class="text-red-500 text-sm mt-2 text-center">Invalid login credentials</p>
            <% } %>
        </form>
    </div>

</body>
</html>
