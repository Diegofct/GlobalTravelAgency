package Plane.infrastructure.in;

import java.util.Scanner;

import Plane.application.CreatePlaneUseCase;
import Plane.domain.service.PlaneService;
import Plane.infrastructure.out.PlaneRepository;

public class CreatePlaneView {
    /*
     * Obtenemos los atributos necesarios para que la vista de crear avion
     * funcione correctamente, tales como
     * el caso de uso (tambien llamada aplicacion), el Scanner, etc.
     */
    private final Scanner scanner;
    private final CreatePlaneUseCase createPlaneUseCase;

    // creamos el constructor para inicializar el caso de uso y obtener el servicio
    public CreatePlaneView(Scanner scanner) {
        // primero obtenemos el scanner
        this.scanner = scanner;
        // obtenemos el servicio
        PlaneService planeService = new PlaneRepository();
        // inicializamos la aplicacion
        this.createPlaneUseCase = new CreatePlaneUseCase(planeService);
    }

    // creamos el metodo start
    public void start() {
        // bucle while
        while (true) {
            try {
                // mensaje de entrada
                System.out.println("CREATING PLANE");
                // obtener los datos necesarios
                String idPlane = 
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
