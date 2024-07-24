package Maintenance.domain.service;

import Maintenance.domain.entity.Maintenance;

public interface MaintenanceService {
    void registerMaintenance(Maintenance maintenance);
    void updateMaintenance(Maintenance maintenance);
    void deleteMaintenance(int idRevision);
    Maintenance readMaintenance(int idRevision);
}


/*
@Override
    public void registerMaintenance(Maintenance maintenance){
        String sql = "INSERT INTO Revision idRevision, revsionDate, idPlane) VALUES (?,?,?) ";
        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1, maintenance.getIdRevision());
                statement.setDate(2, (Date) maintenance.getRevisionDate());
                statement.setInt(3, maintenance.getIdPlane());
                statement.executeUpdate();
        } catch (SQLException m) {
            m.printStackTrace();
        }
    }

    @Override
    public Maintenance findMaintenance(int idRevision){
        String sql = "SELECT *  FROM Revision WHERE idRevision = ?";
        try (Connection connection = DatabaseConfig.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, idRevision);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                Maintenance maintenance = new Maintenance();
                maintenance.setIdRevision(resultSet.getInt("idRevision"));
                maintenance.setRevisionDate(resultSet.getDate("revisionDate"));
                maintenance.setIdPlane(resultSet.getInt("idPlane"));
                return maintenance;
            }
        } catch(SQLException f){
            f.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateMaintenance(Maintenance maintenance){
        String sql = "UPDATE Revision SET  idRevision = ?, revisionDate = ?, idPlane = ? WHERE idRevision = ?";
        try (Connection connection = DatabaseConfig.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, maintenance.getIdRevision());
            statement.setDate(2, (Date) maintenance.getRevisionDate());
            statement.setInt(3, maintenance.getIdPlane());
        } catch(SQLException u){
            u.printStackTrace();
        }
    }

    @Override
    public void deleteMaintenance(int idRevision){
        String sql = "DELETE FROM Revision WHERE idRevision = ?";
        try (Connection connection = DatabaseConfig.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, idRevision);
            statement.executeUpdate();
        } catch(SQLException dm){
            dm.printStackTrace();
        }
    }

    @Override
    public List<Maintenance> getAllMaintenance() {
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
 */