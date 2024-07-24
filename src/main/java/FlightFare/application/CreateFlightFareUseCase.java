package FlightFare.application;

import FlightFare.domain.entity.FlightFare;
import FlightFare.domain.service.FlightFareService;

public class CreateFlightFareUseCase {
    private final FlightFareService flightFareService;

    public CreateFlightFareUseCase(FlightFareService flightFareService) {
        this.flightFareService = flightFareService;
    }

    public void createFlightFare(FlightFare flightFare) {
        flightFareService.createFlightFare(flightFare);
    }
}
