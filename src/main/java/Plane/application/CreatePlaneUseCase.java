package Plane.application;

import Plane.domain.entity.Plane;
import Plane.domain.service.PlaneService;

// Class to handle the use case of creating a plane
public class CreatePlaneUseCase {
    // Dependency injection of the PlaneService
    private final PlaneService planeService;
    
    // Constructor to initialize the PlaneService
    public CreatePlaneUseCase(PlaneService planeService) {
        this.planeService = planeService;
    }

    public void createPlane(Plane plane) {
        planeService.createPlane(plane);
    }
}