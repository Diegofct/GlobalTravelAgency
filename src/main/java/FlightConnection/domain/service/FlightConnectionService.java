package FlightConnection.domain.service;

import FlightConnection.domain.entity.FlightConnection;

public interface FlightConnectionService {
    void createFlightConnection(FlightConnection flightConnection);
    void updateFlightConnection(FlightConnection flightConnection);
    void deleteFlightConnection(int idFlightConnection);
    FlightConnection readFlightConnection(int idFlightConnection);
}
