package Plane.infrastructure.in;

import java.util.List;

import Plane.application.ListPlaneUseCase;
import Plane.domain.entity.Plane;
import Plane.domain.service.PlaneService;
import Plane.infrastructure.out.PlaneRepository;
import Utils.MyUtils;

public class GetPlanesView {
    // obtenemos las herramientas aplicaciones, etc
    private final ListPlaneUseCase listPlaneUseCase;

    // constructor
    public GetPlanesView() {
        // obtenemos el servicio
        PlaneService planeService = new PlaneRepository();
        // inicializamos la app
        this.listPlaneUseCase = new ListPlaneUseCase(planeService);
    }

    // metodo
    public void start() {

        List<Plane> planes = listPlaneUseCase.execute(); // ejecutamos y guardamos la lista de aviones en esta nueva lista

        if (planes != null && !planes.isEmpty()) { // si hay registros; se muestran los aviones
            String leftAlignFormat = "| %-4d | %-30s | %-19d |%n"; // formato 4 digitos, 30 caracteres, 19 digitos
            System.out.format("+------+--------------------------------+---------------------+%n");
            System.out.format("| ID   | Placa                          | Capacidad           |%n");
            System.out.format("+------+--------------------------------+---------------------+%n");
            
            // se itera la lista de aviones para poder agregarlos en el menu. se crea una instancia de cada uno
            for (Plane plane : planes) {
                System.out.format(leftAlignFormat, plane.getIdPlane(), plane.getPlate(), plane.getCapacity());
            }
            System.out.format("+------+--------------------------------+---------------------+%n");
        } else {
            // si no hay registros se lanza un mensaje de error
            MyUtils.displayMessageAndClearScreen("Ups! parece que aun no hay registros en la base de datos.", 3);
        }
    }
}
