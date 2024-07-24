package Trip.application;

import Trip.domain.entity.Trip;
import Trip.domain.service.TripService;

public class UpdateTripUseCase {
    private final TripService tripService;

    public UpdateTripUseCase(TripService tripService) {
        this.tripService = tripService;
    }

    public void updateTrip(Trip trip) {
        tripService.updateTrip(trip);
    }
}
