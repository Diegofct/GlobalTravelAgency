package Trip.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.config.DatabaseConfig;
import Trip.domain.entity.Trip;
import Trip.domain.service.TripService;

public class TripRepository implements TripService {

    @Override
    public void createTrip(Trip trip) {
        String sql = "INSERT INTO Trip (idTrip, dateTrip, price, originCity, destinationCity) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, trip.getIdTrip());

             // Convertir java.util.Date a java.sql.Date
             java.util.Date utilDate = trip.getDateTrip();
             java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
             statement.setDate(2, sqlDate);

            statement.setDouble(3, trip.getPrice());
            statement.setString(4, trip.getOriginCity());
            statement.setString(5, trip.getDestinationCity());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTrip(Trip trip) {
        String sql = "UPDATE Trip SET dateTrip = ?, price = ?, originCity = ?, destinationCity = ? WHERE idTrip = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            // Convertir java.util.Date a java.sql.Date
            java.util.Date utilDate = trip.getDateTrip();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            statement.setDate(1, sqlDate);

            statement.setDouble(2, trip.getPrice());
            statement.setString(3, trip.getOriginCity());
            statement.setString(4, trip.getDestinationCity());
            statement.setInt(5, trip.getIdTrip());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTrip(int idTrip) {
        String sql = "DELETE FROM Trip WHERE idTrip = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, idTrip);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Trip readTrip(int idTrip) {
        String sql = "SELECT * FROM Trip WHERE idTrip = ?";
        Trip trip = null;

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, idTrip);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    trip = new Trip();
                    trip.setIdTrip(rs.getInt("idTrip"));
                    trip.setDateTrip(rs.getDate("dateTrip"));
                    trip.setPrice(rs.getDouble("price"));
                    trip.setOriginCity(rs.getString("originCity"));
                    trip.setDestinationCity(rs.getString("destinationCity"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return trip;
    }

}
