package TripBooking.application;

import TripBooking.domain.entity.TripBooking;
import TripBooking.domain.service.TripBookingService;

public class UpdateTripBookingUseCase {
    private final TripBookingService tripBookingService;

    public UpdateTripBookingUseCase(TripBookingService tripBookingService) {
        this.tripBookingService = tripBookingService;
    }

    public void updateTripBooking(TripBooking tripBooking) {
        tripBookingService.updateTripBooking(tripBooking);
    }
}
