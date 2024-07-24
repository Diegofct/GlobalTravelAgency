package FlightFare.application;

import FlightFare.domain.entity.FlightFare;
import FlightFare.domain.service.FlightFareService;

public class UpdateFlightFareUseCase {
    private final FlightFareService flightFareService;

    public UpdateFlightFareUseCase(FlightFareService flightFareService) {
        this.flightFareService = flightFareService;
    }

    public void updateFlightFare(FlightFare flightFare) {
        flightFareService.updateFlightFare(flightFare);
    }
}
