package FlightConnection.application;

import FlightConnection.domain.service.FlightConnectionService;

public class DeleteFlightConnectionUseCase {
    private final FlightConnectionService flightConnectionService;

    public DeleteFlightConnectionUseCase(FlightConnectionService flightConnectionService) {
        this.flightConnectionService = flightConnectionService;
    }

    public void deleteFlightConnection(int idFlightConnection) {
        flightConnectionService.deleteFlightConnection(idFlightConnection);
    }
}
