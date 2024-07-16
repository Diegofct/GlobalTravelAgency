package User.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import DBConnection.config.DatabaseConfig;
import User.domain.entity.Permission;
import User.domain.service.PermissionService;

public class PermissionRepository implements PermissionService {

    private static final Logger LOGGER = Logger.getLogger(PermissionRepository.class.getName());

    @Override
    public List<Permission> getPermissionsByRole(int idRole) {
        String sql = "SELECT p.idPermission, p.description FROM Permission p " +
                     "JOIN RoleHasPermission rp ON p.idPermission = rp.idPermission " +
                     "WHERE rp.idRole = ?";
        List<Permission> permissions = new ArrayList<>();

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idRole);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Permission permission = new Permission();
                    permission.setIdPermission(resultSet.getInt("idPermission"));
                    permission.setDescription(resultSet.getString("description"));
                    permissions.add(permission);
                }
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error fetching permissions by role", e);
        }

        return permissions;
    }
}
