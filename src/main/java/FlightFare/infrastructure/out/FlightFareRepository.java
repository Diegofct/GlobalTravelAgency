package FlightFare.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.config.DatabaseConfig;
import FlightFare.domain.entity.FlightFare;
import FlightFare.domain.service.FlightFareService;

public class FlightFareRepository implements FlightFareService{

    @Override
    public void createFlightFare(FlightFare flightFare) {
        String sql = "INSERT INTO FlightFare (idFlightFare, description, details, value) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, flightFare.getIdFlightFare());
            statement.setString(2, flightFare.getDescription());
            statement.setString(3, flightFare.getDetails());
            statement.setDouble(4, flightFare.getValue());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateFlightFare(FlightFare flightFare) {
        String sql = "UPDATE FlightFare SET description = ?, details = ?, value = ? WHERE idFlightFare = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, flightFare.getDescription());
            statement.setString(2, flightFare.getDetails());
            statement.setDouble(3, flightFare.getValue());
            statement.setInt(4, flightFare.getIdFlightFare());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFlightFare(int idFlightFare) {
        String sql = "DELETE FROM FlightFare WHERE idFlightFare = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, idFlightFare);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FlightFare readFlightFare(int idFlightFare) {
        String sql = "SELECT * FROM FlightFare WHERE idFlightFare = ?";
        FlightFare flightFare = null;
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, idFlightFare);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    flightFare = new FlightFare();
                    flightFare.setIdFlightFare(rs.getInt("idFlightFare"));
                    flightFare.setDescription(rs.getString("description"));
                    flightFare.setDetails(rs.getString("details"));
                    flightFare.setValue(rs.getDouble("value"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flightFare;
    }

}
