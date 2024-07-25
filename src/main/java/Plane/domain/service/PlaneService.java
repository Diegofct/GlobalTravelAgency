package  Plane.domain.service;

import java.util.List;

import Plane.domain.entity.Plane;

public interface PlaneService{
    String createPlane(Plane plane);
    Plane findPlane(int idPlane);
    String updatePlane(Plane plane);
    String deletePlane(int idPlane);
    List<Plane> getAllPlanes();
}
CONCAT("Ups! parece que el avion con el id: ",idPlane," existe actualmente");