package TripBooking.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.config.DatabaseConfig;
import TripBooking.domain.entity.TripBooking;
import TripBooking.domain.service.TripBookingService;

public class TripBookingRepository implements TripBookingService{

    @Override
    public void createTripBooking(TripBooking tripBooking) {
        String sql = "INSERT INTO TripBooking (idTripBooking, date, idTrip) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, tripBooking.getIdTripBooking());

             // Convertir java.util.Date a java.sql.Date
             java.util.Date utilDate = tripBooking.getDate();
             java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
             statement.setDate(2, sqlDate);

            statement.setDouble(3, tripBooking.getIdTrip());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void updateTripBooking(TripBooking tripBooking) {
        String sql = "UPDATE TripBooking SET date = ?, idTrip = ? WHERE idTripBooking = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            // Convertir java.util.Date a java.sql.Date
            java.util.Date utilDate = tripBooking.getDate();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            statement.setDate(1, sqlDate);
            statement.setInt(2, tripBooking.getIdTrip());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTripBooking(int idTripBooking) {
        String sql = "DELETE FROM TripBooking WHERE idTripBooking = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, idTripBooking);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }                
    }

    @Override
    public TripBooking readTripBooking(int idTripBooking) {
        String sql = "SELECT * FROM TripBooking WHERE idTripBooking = ?";
        TripBooking tripBooking = null;

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, idTripBooking);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    tripBooking = new TripBooking();
                    tripBooking.setIdTripBooking(rs.getInt("idTripBooking"));
                    tripBooking.setDate(rs.getDate("date"));
                    tripBooking.setIdTrip(rs.getInt("idTrip"));
                    
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tripBooking;
    }

}
