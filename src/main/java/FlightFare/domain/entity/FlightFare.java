package FlightFare.domain.entity;

public class FlightFare {
    private int idFlightFare;
    private String description;
    private String details;
    private double value;

    public FlightFare() {
    }

    public FlightFare(int idFlightFare, String description, String details, double value) {
        this.idFlightFare = idFlightFare;
        this.description = description;
        this.details = details;
        this.value = value;
    }

    public int getIdFlightFare() {
        return idFlightFare;
    }

    public void setIdFlightFare(int idFlightFare) {
        this.idFlightFare = idFlightFare;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    
    
}
