package TripBooking.application;

import TripBooking.domain.entity.TripBooking;
import TripBooking.domain.service.TripBookingService;

public class CreateTripBookingUseCase {
    private final TripBookingService tripBookingService;

    public CreateTripBookingUseCase(TripBookingService tripBookingService) {
        this.tripBookingService = tripBookingService;
    }

    public void createTripBooking(TripBooking tripBooking) {
        tripBookingService.createTripBooking(tripBooking);
    }
}
