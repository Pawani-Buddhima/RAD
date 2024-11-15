package servlets;

import classes.DatabaseManager;
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
import javax.servlet.http.HttpSession;

@WebServlet(name = "PostJobServlet", urlPatterns = {"/post-job"})
public class PostJobServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {String title = request.getParameter("title");
        String type = request.getParameter("type");
        String requirement = request.getParameter("requirement");
        String description = request.getParameter("description");

        try {
            Connection connection = DatabaseManager.getConnection();
            String sql = "INSERT INTO job_vacancy (rec_id, title, type, requirement, description) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            HttpSession session = request.getSession();
            int userId = Integer.parseInt( session.getAttribute("userId").toString());
            

            statement.setInt(1, userId);
            statement.setString(2, title);
            statement.setString(3, type);
            statement.setString(4, requirement);
            statement.setString(5, description);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                response.sendRedirect("/JobPortalApplication/recruiter_dashboard.jsp");
            } else {
                // Job posting failure
                String errorMessage = "Failed to post the job. Please try again.";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("/JobPortalApplication/recruiter_dashboard.jsp").forward(request, response);
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
            // Handle database error
            String errorMessage = "An error occurred while processing your request.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("/JobPortalApplication/recruiter_dashboard.jsp").forward(request, response);
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(PostJobServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PostJobServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
