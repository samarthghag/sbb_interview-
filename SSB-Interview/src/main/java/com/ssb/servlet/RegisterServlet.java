package com.ssb.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ssb.dao.UserDAO;
import com.ssb.model.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String aadhar = request.getParameter("aadhar");
        String pan = request.getParameter("pan");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String subject = request.getParameter("subject");

        User user = new User(fullName, aadhar, pan, phone, email, password, subject);
        if (UserDAO.registerUser(user)) {
            response.sendRedirect("login.jsp");
        } else {
            response.sendRedirect("register.jsp?error=Registration failed!");
        }
    }
}
