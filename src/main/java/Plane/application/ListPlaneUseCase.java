package Plane.application;

import Plane.domain.entity.Plane;
import Plane.domain.service.PlaneService;

public class ListPlaneUseCase {
    private final PlaneService planeService;

    public ListPlaneUseCase(PlaneService planeService) {
        this.planeService = planeService;
    }

    public void execute (Plane plane){
        planeService.getAllPlanes();
    }
}
