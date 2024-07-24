package FlightConnection.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.config.DatabaseConfig;
import FlightConnection.domain.entity.FlightConnection;
import FlightConnection.domain.service.FlightConnectionService;

public class FlightConnectionRepository implements FlightConnectionService {

    @Override
    public void createFlightConnection(FlightConnection flightConnection) {
        String sql = "INSERT INTO FlightConnection (idFlightConnection, connectionNumber, idTrip, idPlane, idAirport) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, flightConnection.getIdFlightConnection());
            statement.setString(2, flightConnection.getConnectionNumber());
            statement.setInt(3, flightConnection.getIdTrip());
            statement.setInt(4, flightConnection.getIdPlane());
            statement.setString(5, flightConnection.getIdAirport());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }        
    }

    @Override
    public void updateFlightConnection(FlightConnection flightConnection) {
        String sql = "UPDATE FlightConnection SET connectionNumber = ?, idTrip = ?, idPlane = ?, idAirport = ? WHERE idFlightConnection = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, flightConnection.getConnectionNumber());
            statement.setInt(2, flightConnection.getIdTrip());
            statement.setInt(3, flightConnection.getIdPlane());
            statement.setString(4, flightConnection.getIdAirport());
            statement.setInt(5, flightConnection.getIdFlightConnection());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFlightConnection(int idFlightConnection) {
        String sql = "DELETE FROM FlightConnection WHERE idFlightConnection = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, idFlightConnection);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FlightConnection readFlightConnection(int idFlightConnection) {
        String sql = "SELECT * FROM FlightConnection WHERE idFlightConnection = ?";
        FlightConnection flightConnection = null;
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, idFlightConnection);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    flightConnection = new FlightConnection();
                    flightConnection.setIdFlightConnection(rs.getInt("idFlightConnection"));
                    flightConnection.setConnectionNumber(rs.getString("connectionNumber"));
                    flightConnection.setIdTrip(rs.getInt("idTrip"));
                    flightConnection.setIdPlane(rs.getInt("idPlane"));
                    flightConnection.setIdAirport(rs.getString("idAirport"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flightConnection;
    }

}
