package Plane.domain.service;

import java.util.List;

import Plane.domain.entity.Plane;

public interface PlaneService {
    void createPlane(Plane plane);
    Plane findPlane(int idPlane);
    void updatePlane(Plane plane);
    void deletePlane(int idPlane);
    List<Plane> getAllPlanes();
}
