package servlets;

import classes.DatabaseManager;
import classes.JobListing;
import classes.JobListingDAO;
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

@WebServlet(name = "UpdateJobServlet", urlPatterns = {"/JobPortalApplication/update-job"})
public class UpdateJobServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int jobId = Integer.parseInt(request.getParameter("jobId"));
        String title = request.getParameter("title");
        String type = request.getParameter("type");
        String requirements = request.getParameter("requirements");
        String description = request.getParameter("description");

        try {
            Connection connection = DatabaseManager.getConnection();
            JobListingDAO jobListingDAO = new JobListingDAO(connection);

            JobListing jobListing = new JobListing(jobId, title, type, requirements, description);
            jobListingDAO.updateJobListing(jobListing);

            response.sendRedirect("/JobPortalApplication/LoadMyJobList");
            
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database error
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateJobServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UpdateJobServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}