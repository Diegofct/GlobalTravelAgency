package Trip.application;

import Trip.domain.entity.Trip;
import Trip.domain.service.TripService;

public class CreateTripUseCase {
    private final TripService tripService;

    public CreateTripUseCase(TripService tripService) {
        this.tripService = tripService;
    }

    public void createTrip(Trip trip) {
        tripService.createTrip(trip);
    }
}
