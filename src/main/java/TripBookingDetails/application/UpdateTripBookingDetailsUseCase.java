package TripBookingDetails.application;

import TripBookingDetails.domain.entity.TripBookingDetails;
import TripBookingDetails.domain.service.TripBookingDetailsService;

public class UpdateTripBookingDetailsUseCase {
    private final TripBookingDetailsService tripBookingDetailsService;

    public UpdateTripBookingDetailsUseCase(TripBookingDetailsService tripBookingDetailsService) {
        this.tripBookingDetailsService = tripBookingDetailsService;
    }

    public void updateTripBookingDetails(TripBookingDetails tripBookingDetails) {
        tripBookingDetailsService.updateTripBookingDetails(tripBookingDetails);
    }
}
