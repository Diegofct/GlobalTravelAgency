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

    //! Observacion: llamar al metodo execute y no usar la misma palabra clave "createPlane" ya que la aplicacion hace referencia a ello
    //? Cambiamos el tipo de dato de retorno void por String, ya que lo que retornaremos sera una respuesta
    public String execute(Plane plane) {
        return planeService.createPlane(plane);
    }
}
