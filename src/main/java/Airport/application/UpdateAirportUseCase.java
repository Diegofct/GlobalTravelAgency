package Airport.application;

import Airport.domain.entity.Airport;
import Airport.domain.service.AirportService;

public class UpdateAirportUseCase {
    private final AirportService airportService;

    public UpdateAirportUseCase(AirportService airportService) {
        this.airportService = airportService;
    }

    public void updateAirport(Airport airport) {
        airportService.updateAirport(airport);
    }
}
