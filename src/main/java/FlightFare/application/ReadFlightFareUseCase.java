package FlightFare.application;

import FlightFare.domain.entity.FlightFare;
import FlightFare.domain.service.FlightFareService;

public class ReadFlightFareUseCase {
    private final FlightFareService flightFareService;

    public ReadFlightFareUseCase(FlightFareService flightFareService) {
        this.flightFareService = flightFareService;
    }

    public FlightFare readFlightFare(int idFlightFare) {
        FlightFare flightFare = flightFareService.readFlightFare(idFlightFare);
        return flightFare;
    }
}
