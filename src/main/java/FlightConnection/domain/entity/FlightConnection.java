package FlightConnection.domain.entity;

public class FlightConnection {
    private int idFlightConnection;
    private String connectionNumber;
    private int idTrip;
    private int idPlane;
    private String idAirport;

    public FlightConnection() {
    }

    
    public FlightConnection(int idFlightConnection, String connectionNumber, int idTrip, int idPlane,
            String idAirport) {
        this.idFlightConnection = idFlightConnection;
        this.connectionNumber = connectionNumber;
        this.idTrip = idTrip;
        this.idPlane = idPlane;
        this.idAirport = idAirport;
    }


    public int getIdFlightConnection() {
        return idFlightConnection;
    }


    public void setIdFlightConnection(int idFlightConnection) {
        this.idFlightConnection = idFlightConnection;
    }


    public String getConnectionNumber() {
        return connectionNumber;
    }


    public void setConnectionNumber(String connectionNumber) {
        this.connectionNumber = connectionNumber;
    }


    public int getIdTrip() {
        return idTrip;
    }


    public void setIdTrip(int idTrip) {
        this.idTrip = idTrip;
    }


    public int getIdPlane() {
        return idPlane;
    }


    public void setIdPlane(int idPlane) {
        this.idPlane = idPlane;
    }


    public String getIdAirport() {
        return idAirport;
    }


    public void setIdAirport(String idAirport) {
        this.idAirport = idAirport;
    }

    
    
}
