/*package Maintenance.infrastructure.out;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
}
    /*
    @Override
    public List<Maintenance> getAllMaintenances() {
        String sql = "SELECT * FROM Revision";
        List<Maintenance> maintenanceList = new ArrayList<>();

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Maintenance maintenance = new Maintenance();
                maintenance.setIdPlane(resultSet.getInt("idPlane"));
                maintenance.setRevisionDate(resultSet.getDate("revisionDate"));
                maintenance.setIdRevision(resultSet.getInt("idRevision"));
                maintenanceList.add(maintenance);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maintenanceList;
    }
}

    @Override
    public List<Maintenance> listMaintenance(Maintenance maintenance) {
        String sql = "SELECT * FROM Revision WHERE idPlane = ? AND revisionDate = ? AND idRevision = ?";
        List<Maintenance> maintenanceList = new ArrayList<>();
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, maintenance.getIdPlane());
            statement.setDate(2, (Date) maintenance.getRevisionDate());
            statement.setInt(3, maintenance.getIdRevision());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Maintenance m = new Maintenance();
                m.setIdPlane(resultSet.getInt("idPlane"));
                m.setRevisionDate(resultSet.getDate("revisionDate"));
                m.setIdRevision(resultSet.getInt("idRevision"));
                maintenanceList.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maintenanceList;
    }
}

 */