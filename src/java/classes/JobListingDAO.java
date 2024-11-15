package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobListingDAO {

    private Connection connection;

    public JobListingDAO(Connection connection) {
        this.connection = connection;
    }

    // Insert a new job listing into the database
    public void insertJobListing(JobListing jobListing) throws SQLException {
        String sql = "INSERT INTO job_vacancy (title, type, requirement, description) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, jobListing.getTitle());
            statement.setString(2, jobListing.getType());
            statement.setString(3, jobListing.getRequirements());
            statement.setString(4, jobListing.getDescription());
            statement.executeUpdate();
        }
    }

    // Retrieve all job listings from the database
    public List<JobListing> getAllJobListings() throws SQLException {
        List<JobListing> jobListings = new ArrayList<>();
        String sql = "SELECT * FROM job_vacancy";
        try (PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                JobListing jobListing = new JobListing();
                jobListing.setId(resultSet.getInt("vac_id"));
                jobListing.setTitle(resultSet.getString("title"));
                jobListing.setType(resultSet.getString("type"));
                jobListing.setRequirements(resultSet.getString("requirement"));
                jobListing.setDescription(resultSet.getString("description"));
                jobListings.add(jobListing);
            }
        }
        return jobListings;
    }

    // Retrieve a job listing by ID from the database
    public JobListing getJobListingById(int id) throws SQLException {
        String sql = "SELECT * FROM job_vacancy WHERE vac_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    JobListing jobListing = new JobListing();
                    jobListing.setId(resultSet.getInt("vac_id"));
                    jobListing.setTitle(resultSet.getString("title"));
                    jobListing.setType(resultSet.getString("type"));
                    jobListing.setRequirements(resultSet.getString("requirement"));
                    jobListing.setDescription(resultSet.getString("description"));
                    return jobListing;
                }
            }
        }
        return null; // Job listing not found
    }

    // Update a job listing in the database
    public void updateJobListing(JobListing jobListing) throws SQLException {
        String sql = "UPDATE job_vacancy SET title = ?, type = ?, requirement = ?, description = ? WHERE vac_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, jobListing.getTitle());
            statement.setString(2, jobListing.getType());
            statement.setString(3, jobListing.getRequirements());
            statement.setString(4, jobListing.getDescription());
            statement.setInt(5, jobListing.getId());
            statement.executeUpdate();
        }
    }

    // Delete a job listing from the database
    public void deleteJobListing(int id) throws SQLException {
        String sql = "DELETE FROM job_vacancy WHERE vac_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public List<JobListing> displayListings() throws SQLException {
        List<JobListing> jobListings = new ArrayList<>();
        String sql = "SELECT * FROM job_vacancy";
        try (PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                JobListing jobListing = new JobListing();
                jobListing.setId(resultSet.getInt("vac_id"));
                jobListing.setTitle(resultSet.getString("title"));
                jobListing.setType(resultSet.getString("type"));
                jobListing.setRequirements(resultSet.getString("requirement"));
                jobListing.setDescription(resultSet.getString("description"));
                jobListings.add(jobListing);
            }
        }
        return jobListings;
    }

}
