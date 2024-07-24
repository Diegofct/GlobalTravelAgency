package FlightConnection.application;

import FlightConnection.domain.entity.FlightConnection;
import FlightConnection.domain.service.FlightConnectionService;

public class CreateFlightConnectionUseCase {
    private final FlightConnectionService flightConnectionService;

    public CreateFlightConnectionUseCase(FlightConnectionService flightConnectionService) {
        this.flightConnectionService = flightConnectionService;
    }

    public void createFlightConnection(FlightConnection flightConnection) {
        flightConnectionService.createFlightConnection(flightConnection);
    }
}
