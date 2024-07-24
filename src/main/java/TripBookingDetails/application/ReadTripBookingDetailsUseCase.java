package TripBookingDetails.application;

import TripBookingDetails.domain.entity.TripBookingDetails;
import TripBookingDetails.domain.service.TripBookingDetailsService;

public class ReadTripBookingDetailsUseCase {
    private final TripBookingDetailsService tripBookingDetailsService;

    public ReadTripBookingDetailsUseCase(TripBookingDetailsService tripBookingDetailsService) {
        this.tripBookingDetailsService = tripBookingDetailsService;
    }

    public TripBookingDetails readTripBookingDetails(int idTripBookingDetails) {
        TripBookingDetails tripBookingDetails = tripBookingDetailsService.readTripBookingDetails(idTripBookingDetails);
        return tripBookingDetails;
    }
}
