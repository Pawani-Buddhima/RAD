package servlets;

import classes.DatabaseManager;
import classes.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/JobPortalApplication/register"})
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String nic = request.getParameter("nic");
        String dob = request.getParameter("dob");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        try {
            Connection connection = DatabaseManager.getConnection();
            String sql = "INSERT INTO users (firstName, lastName, address, mobile, email, nic, dob, password, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, address);
            statement.setString(4, mobile);
            statement.setString(5, email);
            statement.setString(6, nic);
            statement.setString(7, dob);
            statement.setString(8, User.hashPassword(password));
            statement.setString(9, role);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                response.sendRedirect("/JobPortalApplication/login.jsp"); // Redirect to login page after successful registration
            } else {
                request.setAttribute("registrationError", "Registration failed. Please try again."); // Set error message
                request.getRequestDispatcher("/registration.jsp").forward(request, response); // Forward back to registration page with error message
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
