package Plane.domain.entity;

import java.util.Date;


// Class attributes
public class Plane {
    private int idPlane;
    private String plate;
    private int capacity;
    private Date fabricationDate;
    private int idModel;
    private int idStatus;

    //Empty constructor
    public Plane() {
    }

    //Constructor with all fields
    public Plane(int idPlane, String plate, int capacity, Date fabricationDate, int idModel, int idStatus) {
        this.idPlane = idPlane;
        this.plate = plate;
        this.capacity = capacity;
        this.fabricationDate = fabricationDate;
        this.idModel = idModel;
        this.idStatus = idStatus;
    }

    //Getters and setters
    public int getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(int idPlane) {
        this.idPlane = idPlane;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Date getFabricationDate() {
        return fabricationDate;
    }

    public void setFabricationDate(Date fabricationDate) {
        this.fabricationDate = fabricationDate;
    }

    public int getIdModel() {
        return idModel;
    }

    public void setIdModel(int idModel) {
        this.idModel = idModel;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    
    


}
