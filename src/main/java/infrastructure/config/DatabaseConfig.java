package infrastructure.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private static final String url = "jdbc:mysql://viaduct.proxy.rlwy.net:36702/railway";
    private static final String user = "root";
    private static final String password = "vcYNBvzOdHspdUoefmESInjgetrhslGr";

    public static Connection getConnection() throws  SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
