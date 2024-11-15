package servlets;

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

@WebServlet(name = "JobSearchServlet", urlPatterns = {"/job-search"})
public class JobSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String jobType = request.getParameter("jobType");

        List<JobListing> jobListings = new ArrayList<>();

        try {
            Connection connection = DatabaseManager.getConnection();
            String sql = "SELECT * FROM job_vacancy WHERE title LIKE ? AND type LIKE ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + title + "%");
            statement.setString(2, jobType.isEmpty() ? "%" : jobType);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                JobListing jobListing = new JobListing();
                jobListing.setId(resultSet.getInt("vac_id"));
                jobListing.setTitle(resultSet.getString("title"));
                jobListing.setType(resultSet.getString("type"));
                jobListing.setRequirements(resultSet.getString("requirement"));
                jobListing.setDescription(resultSet.getString("description"));
                jobListings.add(jobListing);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JobSearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(JobSearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("jobListings", jobListings);
        request.getRequestDispatcher("/job_search_results.jsp").forward(request, response);
    }
}


