package servlets;

import classes.Application;
import classes.DatabaseManager;
import classes.JobListing;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminDashboardServlet", urlPatterns = {"/admin-dashboard"})
public class AdminDashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Application> applications = new ArrayList<>();
        List<JobListing> jobListings = new ArrayList<>();

        try {
            Connection connection = DatabaseManager.getConnection();

            // Fetch applications
            String appSql = "SELECT * FROM application";
            PreparedStatement appStatement = connection.prepareStatement(appSql);
            ResultSet appResultSet = appStatement.executeQuery();
            while (appResultSet.next()) {
                Application application = new Application();
                application.setAppId(appResultSet.getInt("app_id"));
                application.setJobSeekerId(appResultSet.getInt("job_seeker_id"));
                application.setFirstName(appResultSet.getString("first_name"));
                application.setLastName(appResultSet.getString("last_name"));
                application.setEmail(appResultSet.getString("email"));
                application.setMobile(appResultSet.getString("mobile"));
                application.setDob(appResultSet.getDate("dob")); // Use getDate for Date fields
                applications.add(application);
            }
            appResultSet.close();
            appStatement.close();

            // Fetch job listings
            String jobSql = "SELECT * FROM job_vacancy";
            PreparedStatement jobStatement = connection.prepareStatement(jobSql);
            ResultSet jobResultSet = jobStatement.executeQuery();
            while (jobResultSet.next()) {
                JobListing jobListing = new JobListing();
                jobListing.setId(jobResultSet.getInt("vac_id"));
                jobListing.setTitle(jobResultSet.getString("title"));
                jobListing.setType(jobResultSet.getString("type"));
                jobListing.setRequirements(jobResultSet.getString("requirements"));
                jobListing.setDescription(jobResultSet.getString("description"));
                jobListings.add(jobListing);
            }
            jobResultSet.close();
            jobStatement.close();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminDashboardServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AdminDashboardServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("applications", applications);
        request.setAttribute("jobListings", jobListings);
        
        request.getRequestDispatcher("/admin_dashboard.jsp").forward(request, response);
    }
}
