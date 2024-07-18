package Plane.application;

import Plane.domain.entity.Plane;
import Plane.domain.service.PlaneService;

public class FindPlaneUseCase {
    // Dependency injection of the PlaneService
    private final PlaneService PlaneService;

    // Constructor to initialize the PlaneService
    public FindPlaneUseCase(PlaneService PlaneService) {
        this.PlaneService = PlaneService;
    }

    // Method to execute the use case of finding a plane by id
    public Plane execute(int idPlane) {
        // Call the findPlane method of the PlaneService to retrieve the plane
        return PlaneService.findPlane(idPlane);
    }
}
