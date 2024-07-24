package TripBookingDetails.domain.entity;

public class TripBookingDetails {
    private int idTripBookingDetails;
    private int idTripBooking;
    private int idCustomer;
    private int idFlightFare;

    public TripBookingDetails() {
    }

    public TripBookingDetails(int idTripBookingDetails, int idTripBooking, int idCustomer, int idFlightFare) {
        this.idTripBookingDetails = idTripBookingDetails;
        this.idTripBooking = idTripBooking;
        this.idCustomer = idCustomer;
        this.idFlightFare = idFlightFare;
    }

    public int getIdTripBookingDetails() {
        return idTripBookingDetails;
    }

    public void setIdTripBookingDetails(int idTripBookingDetails) {
        this.idTripBookingDetails = idTripBookingDetails;
    }

    public int getIdTripBooking() {
        return idTripBooking;
    }

    public void setIdTripBooking(int idTripBooking) {
        this.idTripBooking = idTripBooking;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdFlightFare() {
        return idFlightFare;
    }

    public void setIdFlightFare(int idFlightFare) {
        this.idFlightFare = idFlightFare;
    }

    
    
}
