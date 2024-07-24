package Trip.domain.entity;

import java.util.Date;

public class Trip {
    private int idTrip;
    private Date dateTrip;
    private double price;
    private String originCity;
    private String destinationCity;

    public Trip() {
    }

    public Trip(int idTrip, Date dateTrip, double price, String originCity, String destinationCity) {
        this.idTrip = idTrip;
        this.dateTrip = dateTrip;
        this.price = price;
        this.originCity = originCity;
        this.destinationCity = destinationCity;
    }

    public int getIdTrip() {
        return idTrip;
    }

    public void setIdTrip(int idTrip) {
        this.idTrip = idTrip;
    }

    public Date getDateTrip() {
        return dateTrip;
    }

    public void setDateTrip(Date dateTrip) {
        this.dateTrip = dateTrip;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }
    
}
