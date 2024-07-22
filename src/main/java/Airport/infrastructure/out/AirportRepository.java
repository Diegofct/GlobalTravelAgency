package Airport.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import Airport.domain.entity.Airport;
import Airport.domain.service.AirportService;
import DBConnection.config.DatabaseConfig;
import User.infrastructure.out.UserRepository;

public class AirportRepository implements AirportService {

    private static final Logger LOGGER = Logger.getLogger(UserRepository.class.getName());

    @Override
    public void createAirport(Airport airport) {
        String sql = "INSERT INTO Airport (idAirport, name, idCity) VALUES (?,?,?)";
         try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, airport.getIdAirport());
            statement.setString(2, airport.getName());
            statement.setString(3, airport.getIdCity());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Airport getAirportById(String idAirport) {
        Airport airport = null;
        String sql = "SELECT * FROM Airport WHERE idAirport = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, idAirport);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    airport = new Airport(
                        resultSet.getString("idAirport"),
                        resultSet.getString("name"),
                        resultSet.getString("idCity")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return airport;
    }

    @Override
    public List<Airport> getAllAirports() {
        List<Airport> aeropuertos = new ArrayList<>();
        String sql = "SELECT * FROM Airport";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Airport airport = new Airport(
                    resultSet.getString("idAirport"),
                    resultSet.getString("name"),
                    resultSet.getString("idCity")
                );
                aeropuertos.add(airport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aeropuertos;
    }

    @Override
    public void updateAirport(Airport airport) {
        String sql = "UPDATE Airport SET name = ?, idCity = ? WHERE idAirport = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, airport.getName());
            statement.setString(2, airport.getIdCity());
            statement.setString(3, airport.getIdAirport());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAirport(String idAirport) {
        String sql = "DELETE FROM Airport WHERE idAirport = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, idAirport);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
