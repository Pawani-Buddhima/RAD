package classes;
import classes.Feedback;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FeedbackDAO {
    private Connection connection;

    public FeedbackDAO(Connection connection) {
        this.connection = connection;
    }

    // Insert a new feedback into the database
    public void insertFeedback(Feedback feedback) throws SQLException {
        String sql = "INSERT INTO feedback (name, email, message) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, feedback.getName());
            statement.setString(2, feedback.getEmail());
            statement.setString(3, feedback.getMessage());
            statement.executeUpdate();
        }
    }
}