package TripBooking.domain.service;

import TripBooking.domain.entity.TripBooking;

public interface TripBookingService {
    void createTripBooking(TripBooking tripBooking);
    void updateTripBooking(TripBooking tripBooking);
    void deleteTripBooking(int idTripBooking);
    TripBooking readTripBooking(int idTripBooking);
}
