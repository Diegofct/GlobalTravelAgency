package Airport.application;

import Airport.domain.entity.Airport;
import Airport.domain.service.AirportService;

public class CreateAirportUseCase {
    private final AirportService airportService;

    public CreateAirportUseCase(AirportService airportService) {
        this.airportService = airportService;
    }

    public void createAirport(Airport airport) {
        airportService.createAirport(airport);
    }
}
