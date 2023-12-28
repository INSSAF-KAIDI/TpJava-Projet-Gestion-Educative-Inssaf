package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbjava";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        DatabaseConnector DriverManager = null;
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private Connection getConnection(String url, String user, String password) {
        return null;
    }

}
