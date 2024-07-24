package Trip.domain.service;

import Trip.domain.entity.Trip;

public interface TripService {
    void createTrip(Trip trip);
    void updateTrip(Trip trip);
    void deleteTrip(int idTrip);
    Trip readTrip(int idTrip);
}
