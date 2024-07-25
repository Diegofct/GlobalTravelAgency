package Plane.application;

import Plane.domain.entity.Plane;
import Plane.domain.service.PlaneService;

// This class represents the use case for updating a plane
public class UpdatePlaneUseCase {
    // The plane service that will be used to update the plane
    private final PlaneService planeService;

    // Constructor that takes the plane service as a parameter
    public UpdatePlaneUseCase(PlaneService planeService) {
        this.planeService = planeService;
    }

    // Method that executes the update plane use case
    public String execute(Plane plane){
        // Call the update plane method on the plane service
        return planeService.updatePlane(plane);
    }
}