package Airport.domain.service;

import java.util.List;

import Airport.domain.entity.Airport;

public interface AirportService {
    void createAirport(Airport airport);
    Airport getAirportById(String idAirport);
    List<Airport> getAllAirports();
    void updateAirport(Airport airport);
    void deleteAirport(String idAirport);
}