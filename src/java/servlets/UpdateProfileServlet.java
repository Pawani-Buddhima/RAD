package servlets;

import classes.DatabaseManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdateProfileServlet", urlPatterns = {"/JobPortalApplication/update-profile"})
public class UpdateProfileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String nic = request.getParameter("nic");
        String dobStr = request.getParameter("dob"); // Assuming the date is sent as a string
        String role = request.getParameter("role");
        // ... (other profile fields)

        try {
            Connection connection = DatabaseManager.getConnection();
            String sql = "UPDATE users SET firstName = ?, lastName = ?, address = ?, mobile = ?, email = ?, nic = ?, dob = ?, role = ? WHERE user_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, address);
            statement.setString(4, mobile);
            statement.setString(5, email);
            statement.setString(6, nic);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dob = null;
            try {
                dob = dateFormat.parse(dobStr);
            } catch (ParseException e) {
                e.printStackTrace();
                // Handle parsing error
                request.setAttribute("updateError", "Invalid date format for Date of Birth");
                request.getRequestDispatcher("/profile.jsp?userId=" + userId).forward(request, response);
                return; // Exit the method to avoid further processing
            }

            statement.setDate(7, new java.sql.Date(dob.getTime()));
            statement.setString(8, role);
            statement.setString(9, userId);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                response.sendRedirect("/JobPortalApplication/profile.jsp?userId=" + userId);
            } else {
                // Handle update failure
                request.setAttribute("updateError", "Failed to update user profile");
                request.getRequestDispatcher("/profile.jsp?userId=" + userId).forward(request, response);
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any database-related errors
            request.setAttribute("updateError", "Database error: " + e.getMessage());
            request.getRequestDispatcher("/profile.jsp?userId=" + userId).forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UpdateProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
