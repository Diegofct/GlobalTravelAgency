package Airport.domain.entity;

public class Airport {
    private String idAirport;
    private String name;
    private String idCity;

    public Airport() {
    }

    public Airport(String idAirport, String name, String idCity) {
        this.idAirport = idAirport;
        this.name = name;
        this.idCity = idCity;
    }

    public String getIdAirport() {
        return idAirport;
    }

    public void setIdAirport(String idAirport) {
        this.idAirport = idAirport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCity() {
        return idCity;
    }

    public void setIdCity(String idCity) {
        this.idCity = idCity;
    }

    
    
}
