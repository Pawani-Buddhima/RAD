package servlets;

import classes.DatabaseManager;
import classes.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Connection connection = DatabaseManager.getConnection();
            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, User.hashPassword(password));

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Successful login
                request.getSession().setAttribute("userId", resultSet.getInt("user_id"));
                String role = resultSet.getString("role");
                if (role.equals("admin")) {
                    response.sendRedirect("LoadAdminDash");
                } else if (role.equals("job_seeker")) {
                    response.sendRedirect("job_seeker_dashboard.jsp");
                } else if (role.equals("recruiter")) {
                    response.sendRedirect("recruiter_dashboard.jsp");
                }
            } else {
                // Handle login failure
                request.setAttribute("loginError", "Invalid email or password");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
