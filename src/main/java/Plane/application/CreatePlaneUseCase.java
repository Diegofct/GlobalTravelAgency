package Plane.application;

import Plane.domain.entity.Plane;
import Plane.domain.service.PlaneService;

// Class to handle the use case of creating a plane
public class CreatePlaneUseCase {
    // Dependency injection of the PlaneService
    private final PlaneService PlaneService;
    
    // Constructor to initialize the PlaneService
    public CreatePlaneUseCase(PlaneService PlaneService) {
        this.PlaneService = PlaneService;
    }

    // Method to execute the use case of creating a plane
    public void execute(Plane plane) {
        // Call the createPlane method of the PlaneService to create the plane
        PlaneService.createPlane(plane);
    }
}