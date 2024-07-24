package TripBooking.application;

import TripBooking.domain.service.TripBookingService;

public class DeleteTripBookingUseCase {
    private final TripBookingService tripBookingService;

    public DeleteTripBookingUseCase(TripBookingService tripBookingService) {
        this.tripBookingService = tripBookingService;
    }

    public void deleteTripBooking(int idTripBooking) {
        tripBookingService.deleteTripBooking(idTripBooking);
    }
}
