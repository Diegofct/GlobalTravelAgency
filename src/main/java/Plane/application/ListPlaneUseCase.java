package Plane.application;

import java.util.List;

import Plane.domain.entity.Plane;
import Plane.domain.service.PlaneService;

public class ListPlaneUseCase {
    private final PlaneService planeService;

    public ListPlaneUseCase(PlaneService planeService) {
        this.planeService = planeService;
    }

    //? cambie el tipo de dato de retorno por una lista de aviones
    public List<Plane> execute (){
        return planeService.getAllPlanes();
    }
}
