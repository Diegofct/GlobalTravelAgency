package infrastructure.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    private static final String URL = "jdbc:mysql://viaduct.proxy.rlwy.net:36702/railway";
    private static final String USER = "root";
    private static final String PASSWORD = "vcYNBvzOdHspdUoefmESInjgetrhslGr";

    // Bloque estático para cargar el controlador JDBC
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
