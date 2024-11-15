package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDAO {

    private Connection connection;

    public ApplicationDAO(Connection connection) {
        this.connection = connection;
    }

    // Insert a new job application into the database
    public void insertApplication(Application application) throws SQLException {
        String sql = "INSERT INTO application ( first_name, last_name, email, mobile, dob, resume) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(2, application.getFirstName());
            statement.setString(3, application.getLastName());
            statement.setString(4, application.getEmail());
            statement.setString(5, application.getMobile());
            statement.setDate(6, new java.sql.Date(application.getDob().getTime()));
            statement.setBytes(7, application.getResume());
            statement.executeUpdate();
        }
    }

// Retrieve a job listing by ID from the database
    public Application getJobListingById(int Appid) throws SQLException {
        String sql = "SELECT * FROM application WHERE app_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, Appid);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Application application = new Application();
                    application.setAppId(resultSet.getInt("app_id"));
                    application.setJobSeekerId(resultSet.getInt("job_seeker_id"));
                    application.setFirstName(resultSet.getString("first_name"));
                    application.setLastName(resultSet.getString("last_name"));
                    application.setEmail(resultSet.getString("email"));
                    application.setMobile(resultSet.getString("mobile"));
                    application.setResume(resultSet.getBytes("resume"));
                    return application;
                }
            }
        }
        return null; // Job listing not found
    }

    // Retrieve all job applications for a specific job seeker
    public List<Application> getApplicationsForJobSeeker(int jobSeekerId) throws SQLException {
        List<Application> applications = new ArrayList<>();
        String sql = "SELECT * FROM application WHERE job_seeker_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, jobSeekerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Application application = new Application();
                    application.setAppId(resultSet.getInt("app_id"));
                    application.setJobSeekerId(resultSet.getInt("job_seeker_id"));
                    application.setFirstName(resultSet.getString("first_name"));
                    application.setLastName(resultSet.getString("last_name"));
                    application.setEmail(resultSet.getString("email"));
                    application.setMobile(resultSet.getString("mobile"));
                    application.setResume(resultSet.getBytes("resume"));
                    applications.add(application);
                }
            }
        }
        return applications;
    }

    public List<Application> displayApplications() throws SQLException {
        List<Application> applications = new ArrayList<>();
        String sql = "SELECT * FROM application";
        try (PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Application application = new Application();
                application.setAppId(resultSet.getInt("app_id"));

                application.setFirstName(resultSet.getString("first_name"));
                application.setLastName(resultSet.getString("last_name"));
                application.setEmail(resultSet.getString("email"));
                application.setMobile(resultSet.getString("mobile"));

                applications.add(application);
            }
        }
        return applications;
    }

    // Update the status of a job application
    public void updateApplicationStatus(int applicationId, String newStatus) throws SQLException {
        String sql = "UPDATE application SET status = ? WHERE app_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newStatus);
            statement.setInt(2, applicationId);
            statement.executeUpdate();
        }
    }

    // Delete a job application from the database
    public void deleteApplication(int applicationId) throws SQLException {
        String sql = "DELETE FROM application WHERE app_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, applicationId);
            statement.executeUpdate();
        }
    }

}
