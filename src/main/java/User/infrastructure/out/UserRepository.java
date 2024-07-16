package User.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import User.domain.entity.User;
import User.domain.service.UserService;
import DBConnection.config.DatabaseConfig;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserRepository implements UserService {

    private static final Logger LOGGER = Logger.getLogger(UserRepository.class.getName());

    @Override
    public void createUser(User user) {
        String sql = "INSERT INTO User (idUser, username, email, password, idRole) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setLong(1, user.getIdUser());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setInt(5, user.getIdRole());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setIdUser(generatedKeys.getLong(1));
                }
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error creating user", e);
        }
    }

    @Override
    public User findUser(String username, String password) {
        String sql = "SELECT  idUser, username, email, password, idRole FROM User WHERE username = ? AND password = ?";
        User user = null;

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, username);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    user = new User();
                    user.setIdUser(resultSet.getLong("idUser"));
                    user.setUsername(resultSet.getString("username"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                    user.setIdRole(resultSet.getInt("idRole"));
                }
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error finding user by ID", e);
        }

        return user;
    }

    @Override
    public void loginUser() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loginUser'");
    }

}