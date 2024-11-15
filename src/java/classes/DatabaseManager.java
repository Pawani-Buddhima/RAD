package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/job_portal_database";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    private final static String DRIVER = "com.mysql.jdbc.Driver";

    public static Connection getConnection() throws Exception {
        Class.forName(DRIVER);
        Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        return con;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
