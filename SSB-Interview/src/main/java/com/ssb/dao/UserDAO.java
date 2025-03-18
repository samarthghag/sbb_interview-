package com.ssb.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.ssb.model.User;

public class UserDAO {
    public static boolean registerUser(User user) {
        try (Connection conn = DBConnection.getConnection()) {
        	String query = "INSERT INTO users (full_name, aadhar, pan, phone, email, password, subject) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user.getFullName());
            ps.setString(2, user.getAadhar());
            ps.setString(3, user.getPan());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getPassword());
            ps.setString(7, user.getSubject());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static User loginUser(String email, String password) {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getString("full_name"), rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
