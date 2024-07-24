package TripBookingDetails.application;

import TripBookingDetails.domain.service.TripBookingDetailsService;

public class DeleteTripBookingDetailsUseCase {
    private final TripBookingDetailsService tripBookingDetailsService;

    public DeleteTripBookingDetailsUseCase(TripBookingDetailsService tripBookingDetailsService) {
        this.tripBookingDetailsService = tripBookingDetailsService;
    }

    public void deleteTripBookingDetails(int idTripBookingDetails) {
        tripBookingDetailsService.deleteTripBookingDetails(idTripBookingDetails);
    }
}
