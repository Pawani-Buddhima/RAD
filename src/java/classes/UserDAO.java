package classes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    // Insert a new user into the database
    public void insertUser(User user) throws SQLException {
        String sql = "INSERT INTO users (firstName, lastName, address, mobile, email, nic, dob, password, role) VALUES (?, ?, ?, ?, ?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getAddress());
            statement.setString(4, user.getMobile());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getNIC());
            statement.setString(7, user.getDOB());
            statement.setString(8, user.getPassword());
            statement.setString(9, user.getRole());
            statement.executeUpdate();
        }
    }

    // Retrieve a user by email from the database
    public User getUserByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM users WHERE email = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractUserFromResultSet(resultSet);
                }
            }
        }
        return null; // User not found
    }

    // Helper method to create a User object from a ResultSet
    private User extractUserFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("user_id");
        String firstName = resultSet.getString("firstName");
        String lastName = resultSet.getString("lastName");
        String address = resultSet.getString("address");
        String mobile = resultSet.getString("mobile");
        String userEmail = resultSet.getString("email");
        String nic = resultSet.getString("nic");
        String dob = resultSet.getString("dob");
        String password = resultSet.getString("password");
        String role = resultSet.getString("role");

        return new User(id, firstName, lastName, userEmail, password, role, dob, address, mobile, nic);
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("user_id"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAddress(resultSet.getString("address"));
                user.setMobile(resultSet.getString("mobile"));
                user.setEmail(resultSet.getString("email"));
                user.setNIC(resultSet.getString("nic"));
                user.setDOB(resultSet.getString("dob"));
                users.add(user);
            }
        }
        return users;
    }

}
