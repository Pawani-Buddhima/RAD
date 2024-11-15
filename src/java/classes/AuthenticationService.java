package classes;

import java.sql.Connection;
import java.sql.SQLException;

public class AuthenticationService {
    private UserDAO userDAO;

    public AuthenticationService(Connection connection) {
        userDAO = new UserDAO(connection);
    }

    // Validate user login
    public boolean validateLogin(String email, String password) throws SQLException {
        User user = userDAO.getUserByEmail(email);
        if (user != null && user.validatePassword(password)) {
            return true;
        }
        return false;
    }

    // Check user role
    public boolean checkUserRole(String email, String requiredRole) throws SQLException {
        User user = userDAO.getUserByEmail(email);
        if (user != null && user.getRole().equals(requiredRole)) {
            return true;
        }
        return false;
    }
}
