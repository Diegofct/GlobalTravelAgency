package FlightFare.domain.service;

import FlightFare.domain.entity.FlightFare;

public interface FlightFareService {
    void createFlightFare(FlightFare flightFare);
    void updateFlightFare(FlightFare flightFare);
    void deleteFlightFare(int idFlightFare);
    FlightFare readFlightFare(int idFlightFare);
}
