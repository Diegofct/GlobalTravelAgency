package Airport.application;

import Airport.domain.service.AirportService;

public class DeleteAirportUseCase {
    private final AirportService airportService;

    public DeleteAirportUseCase(AirportService airportService) {
        this.airportService = airportService;
    }

    public void deleteAirport(String idAirport) {
        airportService.deleteAirport(idAirport);
    }
}
