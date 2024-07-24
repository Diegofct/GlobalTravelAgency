package Maintenance.infrastructure.out;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.config.DatabaseConfig;
import Maintenance.domain.entity.Maintenance;
import Maintenance.domain.service.MaintenanceService;

public class MaintenanceRepository implements MaintenanceService {
     

    @Override
    public void registerMaintenance(Maintenance maintenance) {
        String sql = "INSERT INTO Revision (idRevision, revisionDate, idPlane) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, maintenance.getIdRevision());
            statement.setDate(2, (Date) maintenance.getRevisionDate());
            statement.setInt(3, maintenance.getIdPlane());
            statement.executeUpdate();
        } catch (SQLException m) {
            m.printStackTrace();
        }
    }

    @Override
    public void updateMaintenance(Maintenance maintenance) {
        String sql = "UPDATE Revision SET revisionDate = ?, idPlane = ? WHERE idRevision = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, (Date) maintenance.getRevisionDate());
            statement.setInt(2, maintenance.getIdPlane());
            statement.setInt(3, maintenance.getIdRevision());
            statement.executeUpdate(); // This line was missing
        } catch (SQLException u) {
            u.printStackTrace();
        }
    }

    @Override
    public void deleteMaintenance(int idRevision) {
        String sql = "DELETE FROM Revision WHERE idRevision = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idRevision);
            statement.executeUpdate();
        } catch (SQLException dm) {
            dm.printStackTrace();
        }
    }

    @Override
    public Maintenance readMaintenance(int idRevision) {
        String sql = "SELECT * FROM Revision WHERE idRevision = ?";
        Maintenance maintenance = null;
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idRevision);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    maintenance = new Maintenance();
                    maintenance.setIdRevision(rs.getInt("idRevision"));
                    maintenance.setRevisionDate(rs.getDate("revisionDate"));
                    maintenance.setIdPlane(rs.getInt("idPlane"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maintenance;   
    }

}