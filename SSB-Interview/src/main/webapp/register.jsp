<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
    <link rel="stylesheet" href="css/styles.css">
    <script src="js/script.js"></script>
</head>
<body>
<div class="container">
        <h2>User Registration</h2>
        <form action="register" method="post" onsubmit="return validateForm()">
            <input type="text" name="fullName" placeholder="Full Name" required>
            <input type="text" id="aadhar" name="aadhar" placeholder="Aadhar Number" required>
            <input type="text" name="pan" placeholder="PAN Number" required>
            <input type="text" id="phone" name="phone" placeholder="Phone Number" required>
            <input type="email" id="email" name="email" placeholder="Email" required>
            <input type="password" name="password" placeholder="Password" required>
            <select name="subject" required>
                <option value="">Select Subject</option>
                <option value="Technical">Technical</option>
                <option value="Non-Technical">Non-Technical</option>
            </select>
            <button type="submit">Register</button>
        </form>
        <p>Already have an account? <a href="login.jsp">Login here</a></p>
    </div>
</body>
</html>