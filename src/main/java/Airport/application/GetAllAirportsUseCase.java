package Airport.application;

import Airport.domain.entity.Airport;
import Airport.domain.service.AirportService;

public class GetAllAirportsUseCase {

    private final AirportService airportService;

    public GetAllAirportsUseCase(AirportService airportService) {
        this.airportService = airportService;
    }

    public void getAllAirportsUseCase(Airport airport) {
        airportService.getAllAirports();
    }
}
