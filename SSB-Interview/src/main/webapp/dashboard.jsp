<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession userSession = request.getSession(false);
    if (userSession == null || userSession.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="navbar">
        <a href="uploadDocuments.jsp">Upload Documents</a>
        <a href="logout">Logout</a>
    </div>
    <div class="container">
        <h2>Welcome, <%= userSession.getAttribute("user") %></h2>
        <p>You can upload your necessary documents for the SSB Interview.</p>
    </div>
</body>
</html>
