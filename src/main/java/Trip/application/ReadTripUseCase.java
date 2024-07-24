package Trip.application;

import Trip.domain.entity.Trip;
import Trip.domain.service.TripService;

public class ReadTripUseCase {
    private final TripService tripService;

    public ReadTripUseCase(TripService tripService) {
        this.tripService = tripService;
    }

    public Trip readTrip(int idTrip) {
        Trip trip = tripService.readTrip(idTrip);
        return trip;
    }
}