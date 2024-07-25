package Plane.infrastructure.in;

import java.util.InputMismatchException;
import java.util.Scanner;

import Plane.application.DeletePlaneUseCase;
import Plane.domain.service.PlaneService;
import Plane.infrastructure.out.PlaneRepository;
import Utils.MyUtils;

public class DeletePlaneView {
    // obtenemos la aplicacion, el scannerm etc
    private final DeletePlaneUseCase deletePlaneUseCase;
    private final Scanner scanner;

    public DeletePlaneView(Scanner scanner) {
        // obtenemos el scanner
        this.scanner = scanner;
        // obtenemos el servicio
        PlaneService planeService = new PlaneRepository();
        // inicializamos la aplicacion
        this.deletePlaneUseCase = new DeletePlaneUseCase(planeService);
    }

    public void start() {
        while (true) { 
            try {

                // mensaje de entrada
                System.out.println("ELIMINANDO UN AVION");
                // obtenemos los datos
                int idPlane = MyUtils.getIntInput("Ingresa el id del avion: ", scanner);
                // eliminamos y obtenemos respuesta
                String response = deletePlaneUseCase.execute(idPlane);
                // mostramos la respuesta
                MyUtils.displayMessageAndClearScreen(response, 2);
                // salimos de la vista
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine(); // limpiamos el buffer
                MyUtils.displayMessageAndClearScreen("Ups! asegúrate de ingresar solo datos numéricos. Por favor intenta de nuevo", 2);
            }
        }
    }
    
}
