package FlightConnection.application;

import FlightConnection.domain.entity.FlightConnection;
import FlightConnection.domain.service.FlightConnectionService;

public class UpdateFlightConnectionUseCase {
    private final FlightConnectionService flightConnectionService;

    public UpdateFlightConnectionUseCase(FlightConnectionService flightConnectionService) {
        this.flightConnectionService = flightConnectionService;
    }

    public void updateFlightConnection(FlightConnection flightConnection) {
        flightConnectionService.updateFlightConnection(flightConnection);
    }
}
