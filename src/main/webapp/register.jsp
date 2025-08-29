<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gradient-to-r from-blue-200 to-blue-100 min-h-screen flex items-center justify-center">

	<%
		HttpSession sess = request.getSession(false);
		if(sess.getAttribute("customer") != null){
			response.sendRedirect("dashboard.jsp");
		}
	%>
	
    <div class="bg-white p-5 rounded-lg shadow-lg w-full max-w-md">
        <h2 class="text-2xl font-bold text-center mb-6 text-blue-600">Customer Registration</h2>
        <form action="CustomerRegisterController" method="post" class="space-y-4">
            <div class="flex justify-between gap-5">
                <div> 
                	<label class="block font-medium mb-1">First Name</label>
                	<input type="text" name="firstnameTxt" class="w-full border border-gray-300 rounded-md px-4 py-2" placeholder="First Name" required>
                </div>
                <div>
                	<label class="block font-medium mb-1">Last Name</label>
                	<input type="text" name="lastnameTxt" class="w-full border border-gray-300 rounded-md px-4 py-2" placeholder="Last Name" required>
                </div>
            </div>
            <div class="flex gap-10 items-center">
            	<label class="block font-medium mb-1"> Gender : </label>
            	<div class="flex items-center">
            		<input type="radio" name="genderTxt" class="mr-1" required value="Male"> Male </input>
           	 		<input type="radio" name="genderTxt" class="ml-5 mr-1" value="Female" required="required"> Female </input>
            		<input type="radio" name="genderTxt" class="ml-5 mr-1" value="Other" required="required"> Other </input>
            	</div>
            </div>
            <div class="flex gap-10 items-center">
            	<label class="block font-medium mb-1"> Date of Birth : </label>
            	<input type="date" name="dobTxt" class="border border-gray-400 rounded-md px-2 py-2" placeholder="Select date" required="required"/>
            </div>
            <div class="flex gap-5">
            	<div>
            	    <label class="block font-medium mb-1">Email</label>
            	    <input type="email" name="emailTxt" class="w-full border border-gray-300 rounded-md px-4 py-2" placeholder="Email" required>
            	</div>
            	<div>
            	    <label class="block font-medium mb-1">Phone</label>
            	    <input type="text" name="phoneTxt" class="w-full border border-gray-300 rounded-md px-4 py-2" placeholder="Mobile" required>
            	</div>
            </div>
            <div class="flex gap-5 items-center">
            	<div>
            		<label class="block font-medium mb-1"> Aadhar Card </label>
            		<input type="text" name="aadharTxt" class="w-full border border-gray-300 rounded-md px-4 py-2" placeholder="Aadhar number" />
            	</div>
            	<div>
            		<label class="block font-medium mb-1"> PAN Card </label>
            		<input type="text" name="panTxt" class="w-full border border-gray-300 rounded-md px-4 py-2" placeholder="PAN number" />
            	</div>
            </div>
            
            <div>
                <label class="block font-medium mb-1">Password</label>
                <input type="password" name="passwordTxt" class="w-full border border-gray-300 rounded-md px-4 py-2" placeholder="Password" required>
            </div>
            <button type="submit" class="w-full bg-blue-600 text-white py-2 rounded-xl hover:bg-blue-700 transition">
                Register
            </button>
            <p class="text-center mt-4 text-sm">Already registered? <a href="login.jsp" class="text-blue-600 font-medium hover:underline">Login</a></p>
        </form>
    </div>

</body>
</html>
