package DBConnection.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    private static final String URL = "jdbc:mysql://viaduct.proxy.rlwy.net:36702/railway";
    private static final String USER = "root";
    private static final String PASSWORD = "vcYNBvzOdHspdUoefmESInjgetrhslGr";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
