package TripBookingDetails.application;

import TripBookingDetails.domain.entity.TripBookingDetails;
import TripBookingDetails.domain.service.TripBookingDetailsService;

public class CreateTripBookingDetailsUseCase {
    private final TripBookingDetailsService tripBookingDetailsService;

    public CreateTripBookingDetailsUseCase(TripBookingDetailsService tripBookingDetailsService) {
        this.tripBookingDetailsService = tripBookingDetailsService;
    }

    public void createTripBookingDetails(TripBookingDetails tripBookingDetails) {
        tripBookingDetailsService.createTripBookingDetails(tripBookingDetails);
    }
}
