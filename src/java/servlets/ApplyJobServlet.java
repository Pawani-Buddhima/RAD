
package servlets;

import classes.DatabaseManager;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "ApplyJobServlet", urlPatterns = {"/applyjob"})
@MultipartConfig
public class ApplyJobServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        
        Part resumePart = request.getPart("resume");
        InputStream resumeInputStream = resumePart.getInputStream();

        try {
            Connection connection = DatabaseManager.getConnection();
            String sql = "INSERT INTO application (first_name, last_name, email, mobile, resume) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, email);
            statement.setString(4, mobile);
            statement.setBinaryStream(5, resumeInputStream);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                response.sendRedirect("/job_seeker_dashboard.jsp"); // Redirect to job seeker's dashboard after successful application
            } else {
                // Handle application submission failure
                request.setAttribute("applicationError", "Application submission failed. Please try again.");
                request.getRequestDispatcher("/apply_job.jsp").forward(request, response);
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ApplyJobServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ApplyJobServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


  