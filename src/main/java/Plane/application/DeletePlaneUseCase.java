package Plane.application;

import Plane.domain.service.PlaneService;

// This class represents the use case for deleting a plane
public class DeletePlaneUseCase {
    // Dependency injection of the PlaneService
    private final PlaneService planeService;

    // Constructor for the DeletePlaneUseCase
    public DeletePlaneUseCase(PlaneService planeService) {
        // Initialize the planeService field
        this.planeService = planeService;
    }

    // Method to execute the deletion of a plane
    public void deletePlane(int idPlane) {
        // Call the deletePlane method on the planeService
        planeService.deletePlane(idPlane);
    }
}