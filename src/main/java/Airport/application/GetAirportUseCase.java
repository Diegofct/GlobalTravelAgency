package Airport.application;

import Airport.domain.entity.Airport;
import Airport.domain.service.AirportService;

public class GetAirportUseCase {
    private final AirportService airportService;

    public GetAirportUseCase(AirportService airportService) {
        this.airportService = airportService;
    }

    public Airport getAirportById(String idAirport) {
        Airport airport = airportService.getAirportById(idAirport);
        return airport;
    }
    
}
