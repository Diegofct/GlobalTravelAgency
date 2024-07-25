package Plane.infrastructure.in;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import Plane.application.FindPlaneUseCase;
import Plane.domain.entity.Plane;
import Plane.domain.service.PlaneService;
import Plane.infrastructure.out.PlaneRepository;
import Utils.MyUtils;

public class FindPlaneView {
    // se obtiene la aplication y el scanner
    private final FindPlaneUseCase findPlaneUseCase;
    private final Scanner scanner;

    public FindPlaneView(Scanner scanner) {
        // obtener el scanner
        this.scanner = scanner;
        // obtener el servicio
        PlaneService planesService = new PlaneRepository();
        // inicializar la aplicacion
        this.findPlaneUseCase = new FindPlaneUseCase(planesService);
    }

    // metodo
    public void start() {
        while (true) { 
            try {
                // Mensaje de entrada
                System.out.println("BUSCANDO AVION");
                // obtener los datos
                int idPlane = MyUtils.getIntInput("Ingrese el id del avion que quiere encontrar: ", scanner);
                // ejecutar y obtener avion
                Plane plane = findPlaneUseCase.execute(idPlane);

                if (plane != null) {
                    showPlane(plane); // si el avion no es nulo, mostramos el avion
                    break; // salimos del bucle
                } else { // si no hay registro, salir del bucle
                    MyUtils.displayMessageAndClearScreen("Ups! parece que el avion no existe.", 2);
                    break;
                }

            } catch (InputMismatchException e) {
                scanner.nextLine(); // limpiamos el buffer
                MyUtils.displayMessageAndClearScreen("Ups! asegúrate de ingresar solo datos numéricos. Por favor intenta de nuevo", 2);
            }
        }
    }

    // metodo privado para mostrar el avion
    private void showPlane(Plane plane) {
        String leftAlignFormat = "| %-4d | %-30s | %-19d |%n"; // formato 4 digitos, 30 caracteres, 19 digitos
        System.out.format("+------+--------------------------------+---------------------+%n");
        System.out.format("| ID   | Placa                          | Capacidad           |%n");
        System.out.format("+------+--------------------------------+---------------------+%n");
        System.out.format(leftAlignFormat, plane.getIdPlane(), plane.getPlate(), plane.getCapacity());
        System.out.format("+------+--------------------------------+---------------------+%n");
        System.out.println("                     Press enter to continue...                     ");
        try {
            System.in.read(); // leer el teclado
        } catch (IOException e) {
            e.printStackTrace(); // si ocurre alguna excepción de input u output manejarlo
        }
        scanner.nextLine(); // limpiar buffer
    }
}