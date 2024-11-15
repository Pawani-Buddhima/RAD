package servlets;

import classes.DatabaseManager;
import classes.JobListing;
import java.io.IOException;
import java.sql.Connection;
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

@WebServlet(name = "EditJobServlet", urlPatterns = {"/JobPortalApplication/edit-job"})
public class EditJobServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int jobId = Integer.parseInt(request.getParameter("jobId"));

        try {
            Connection connection = DatabaseManager.getConnection();
            String sql = "SELECT * FROM job_vacancy WHERE vac_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, jobId);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                JobListing jobListing = new JobListing();
                jobListing.setId(resultSet.getInt("vac_id"));
                jobListing.setTitle(resultSet.getString("title"));
                jobListing.setType(resultSet.getString("type"));
                jobListing.setRequirements(resultSet.getString("requirement"));
                jobListing.setDescription(resultSet.getString("description"));

                request.setAttribute("jobListing", jobListing);
                request.getRequestDispatcher("/edit_job.jsp").forward(request, response);
            } else {
                // Handle job not found
                response.sendRedirect("/JobPortalApplication/LoadMyJobList");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database error
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditJobServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(EditJobServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
