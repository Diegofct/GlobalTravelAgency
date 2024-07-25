package Plane.infrastructure.in;

import java.text.ParseException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import Plane.application.CreatePlaneUseCase;
import Plane.domain.entity.Plane;
import Plane.domain.service.PlaneService;
import Plane.infrastructure.out.PlaneRepository;
import Utils.MyUtils;

public class CreatePlaneView {
    /*
     * Obtenemos los atributos necesarios para que la vista de crear avion
     * funcione correctamente, tales como
     * el caso de uso (tambien llamada aplicacion), el Scanner, etc.
     */
    private final Scanner scanner;
    private final CreatePlaneUseCase createPlaneUseCase;
    private static final int MAX_PLATE_LENGTH = 10; // constante

    // creamos el constructor para inicializar el caso de uso y obtener el servicio
    public CreatePlaneView(Scanner scanner) {
        // primero obtenemos el scanner
        this.scanner = scanner;
        // obtenemos el servicio
        PlaneService planeService = new PlaneRepository();
        // inicializamos la aplicación
        this.createPlaneUseCase = new CreatePlaneUseCase(planeService);
    }

    // creamos el metodo start
    public void start() {
        // bucle while
        while (true) {
            try {
                // mensaje de entrada
                System.out.println("CREANDO AVION");
                
                // obtener los datos necesarios
                int idPlane = MyUtils.getIntInput("Ingrese el id del avion: ", scanner);
                String plate = MyUtils.getInput("Ingrese la placa del avion (10 caracteres): ", scanner);

                // verificamos que la placa tenga los caracteres especificados
                if (isPlateInvalid(plate)) {
                    MyUtils.displayMessageAndClearScreen("Ups! parece que excediste el limite de caracteres, intenta nuevamente.", 2);
                    continue; // reiniciar el bucle
                }

                int capacity = MyUtils.getIntInput("Ingrese la capacidad del avion: ", scanner);
                Date fabricationDate = MyUtils.getDateInput("Ingrese la fecha de fabricación (yyyy-MM-dd): ", scanner);
                int idModel = MyUtils.getIntInput("Ingrese el id del modelo: ", scanner);
                int idStatus = MyUtils.getIntInput("Ingrese el id del estado: ", scanner);

                // creamos un nueva instancia de avion y le pasamos todos los parámetros que acabamos de pedir al usuario
                Plane newPlane = new Plane(idPlane, plate, capacity, fabricationDate, idModel, idStatus);

                // ejecutar la aplicación y obtener la respuesta
                String response = createPlaneUseCase.execute(newPlane);

                // desplegar el mensaje al usuario por 2 segundos
                MyUtils.displayMessageAndClearScreen(response, 2);

                // salir del bucle (finalizar)
                break;
            } catch (InputMismatchException e) { // Manejo de inputmismatch que es por si el usuario ingresa un dato no numérico
                scanner.nextLine(); // limpiamos el buffer
                MyUtils.displayMessageAndClearScreen("Ups! asegúrate de ingresar solo datos numéricos. Por favor intenta de nuevo", 2);
            } catch (ParseException e) { // manejo de parse exception, por si el usuario ingresa una fecha en otro formato que no es yyyy-mm-dd
                MyUtils.displayMessageAndClearScreen("Ups! formato de fecha no valido, por favor intenta nuevamente.", 2);
            }
        }
    }

    private boolean isPlateInvalid(String plate) {
        return  plate.length() > MAX_PLATE_LENGTH;
    }
}
