package FlightFare.application;

import FlightFare.domain.service.FlightFareService;

public class DeleteFlightFareUseCase {
    private final FlightFareService flightFareService;

    public DeleteFlightFareUseCase(FlightFareService flightFareService) {
        this.flightFareService = flightFareService;
    }

    public void deleteFlightFare(int idFlightFare) {
        flightFareService.deleteFlightFare(idFlightFare);
    }
}
