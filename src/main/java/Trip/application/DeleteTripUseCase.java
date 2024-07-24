package Trip.application;

import Trip.domain.service.TripService;

public class DeleteTripUseCase {
    private final TripService tripService;

    public DeleteTripUseCase(TripService tripService) {
        this.tripService = tripService;
    }

    public void deleteTrip(int idTrip) {
        tripService.deleteTrip(idTrip);
    }
}
