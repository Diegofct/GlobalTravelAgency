package TripBookingDetails.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.config.DatabaseConfig;
import TripBookingDetails.domain.entity.TripBookingDetails;
import TripBookingDetails.domain.service.TripBookingDetailsService;

public class TripBookingDetailsRepository implements TripBookingDetailsService {

    @Override
    public void createTripBookingDetails(TripBookingDetails tripBookingDetails) {
        String sql = "INSERT INTO TripBookingDetails (idTripBookingDetails, idTripBooking, idCustomer, idFlightFare) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
             
            statement.setInt(1, tripBookingDetails.getIdTripBookingDetails());
            statement.setInt(2, tripBookingDetails.getIdTripBooking());
            statement.setInt(3, tripBookingDetails.getIdCustomer());
            statement.setInt(4, tripBookingDetails.getIdFlightFare());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTripBookingDetails(TripBookingDetails tripBookingDetails) {
        String sql = "UPDATE TripBookingDetails SET idTripBooking = ?, idCustomer = ?, idFlightFare = ? WHERE idTripBookingDetails = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, tripBookingDetails.getIdTripBooking());
            statement.setInt(2, tripBookingDetails.getIdCustomer());
            statement.setInt(3, tripBookingDetails.getIdFlightFare());
            statement.setInt(4, tripBookingDetails.getIdTripBookingDetails());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTripBookingDetails(int idTripBookingDetails) {
        String sql = "DELETE FROM TripBookingDetails WHERE idTripBookingDetails = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, idTripBookingDetails);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public TripBookingDetails readTripBookingDetails(int idTripBookingDetails) {
        String sql = "SELECT * FROM TripBookingDetails WHERE idTripBookingDetails = ?";
        TripBookingDetails tripBookingDetails = null;

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, idTripBookingDetails);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    tripBookingDetails = new TripBookingDetails();
                    tripBookingDetails.setIdTripBookingDetails(rs.getInt("idTripBookingDetails"));
                    tripBookingDetails.setIdTripBooking(rs.getInt("idTripBooking"));
                    tripBookingDetails.setIdCustomer(rs.getInt("idCustomer"));
                    tripBookingDetails.setIdFlightFare(rs.getInt("idFlightFare"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tripBookingDetails;
    }

}
