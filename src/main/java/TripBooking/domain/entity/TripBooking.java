package TripBooking.domain.entity;

import java.util.Date;

public class TripBooking {
    private int idTripBooking;
    private Date date;
    private int idTrip;
    
    public TripBooking() {
    }

    public TripBooking(int idTripBooking, Date date, int idTrip) {
        this.idTripBooking = idTripBooking;
        this.date = date;
        this.idTrip = idTrip;
    }

    public int getIdTripBooking() {
        return idTripBooking;
    }

    public void setIdTripBooking(int idTripBooking) {
        this.idTripBooking = idTripBooking;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdTrip() {
        return idTrip;
    }

    public void setIdTrip(int idTrip) {
        this.idTrip = idTrip;
    }

    
}
