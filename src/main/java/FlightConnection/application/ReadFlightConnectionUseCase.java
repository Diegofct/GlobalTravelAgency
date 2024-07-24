package FlightConnection.application;

import FlightConnection.domain.entity.FlightConnection;
import FlightConnection.domain.service.FlightConnectionService;

public class ReadFlightConnectionUseCase {
    private final FlightConnectionService flightConnectionService;

    public ReadFlightConnectionUseCase(FlightConnectionService flightConnectionService) {
        this.flightConnectionService = flightConnectionService;
    }

    public FlightConnection readFlightConnection(int idFlightConnection) {
        FlightConnection flightConnection = flightConnectionService.readFlightConnection(idFlightConnection);
        return flightConnection;
    }
}
