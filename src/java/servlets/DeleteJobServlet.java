package servlets;

import classes.DatabaseManager;
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

@WebServlet(name = "DeleteJobServlet", urlPatterns = {"/JobPortalApplication/delete-job"})
public class DeleteJobServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int jobId = Integer.parseInt(request.getParameter("jobId"));

        try {
            Connection connection = DatabaseManager.getConnection();
            JobListingDAO jobListingDAO = new JobListingDAO(connection);

            jobListingDAO.deleteJobListing(jobId);

            response.sendRedirect("/JobPortalApplication/LoadMyJobList");
            
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database error
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DeleteJobServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DeleteJobServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}