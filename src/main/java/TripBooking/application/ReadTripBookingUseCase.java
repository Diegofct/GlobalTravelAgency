package TripBooking.application;

import TripBooking.domain.entity.TripBooking;
import TripBooking.domain.service.TripBookingService;

public class ReadTripBookingUseCase {
    private final TripBookingService tripBookingService;

    public ReadTripBookingUseCase(TripBookingService tripBookingService) {
        this.tripBookingService = tripBookingService;
    }

    public TripBooking readTripBooking(int idTripBooking) {
        TripBooking tripBooking = tripBookingService.readTripBooking(idTripBooking);
        return tripBooking;
    }
}
