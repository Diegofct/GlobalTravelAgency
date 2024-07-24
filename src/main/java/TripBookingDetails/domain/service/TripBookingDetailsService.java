package TripBookingDetails.domain.service;

import TripBookingDetails.domain.entity.TripBookingDetails;

public interface TripBookingDetailsService {
    void createTripBookingDetails(TripBookingDetails tripBookingDetails);
    void updateTripBookingDetails(TripBookingDetails tripBookingDetails);
    void deleteTripBookingDetails(int idTripBookingDetails);
    TripBookingDetails readTripBookingDetails(int idTripBookingDetails);
}
