package Plane.infrastructure.in;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import Plane.application.CreatePlaneUseCase;
import Plane.application.DeletePlaneUseCase;
import Plane.application.FindPlaneUseCase;
import Plane.application.ListPlaneUseCase;
import Plane.application.UpdatePlaneUseCase;
import Plane.domain.entity.Plane;

public class PlaneController {
    
    private final CreatePlaneUseCase createPlaneUseCase;
    private final DeletePlaneUseCase deletePlaneUseCase;
    private final FindPlaneUseCase findPlaneUseCase;
    private final ListPlaneUseCase listPlaneUseCase;
    private final UpdatePlaneUseCase updatePlaneUseCase;

    public PlaneController(CreatePlaneUseCase createPlaneUseCase, DeletePlaneUseCase deletePlaneUseCase,
            FindPlaneUseCase findPlaneUseCase, ListPlaneUseCase listPlaneUseCase,
            UpdatePlaneUseCase updatePlaneUseCase) {
        this.createPlaneUseCase = createPlaneUseCase;
        this.deletePlaneUseCase = deletePlaneUseCase;
        this.findPlaneUseCase = findPlaneUseCase;
        this.listPlaneUseCase = listPlaneUseCase;
        this.updatePlaneUseCase = updatePlaneUseCase;
    }

    public void createPlane() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese el id del Avión: ");
            int idPlane = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese la placa del Avión: ");
            String plate = scanner.nextLine();

            System.out.println("Digite la capacidad que tiene el Avión: ");
            int capacity = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese la fecha de fabricación del Avión (formato: yyyy-MM-dd): ");
            String fabricationDateStr = scanner.nextLine();
            LocalDate fabricationLocalDate = LocalDate.parse(fabricationDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Date fabricationDate = Date.from(fabricationLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

            System.out.println("Ingrese el id del Modelo: ");
            int idModel = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese el id del estado: ");
            int idStatus = scanner.nextInt();
            scanner.nextLine();

            Plane plane = new Plane();
            plane.setIdPlane(idPlane);
            plane.setPlate(plate);
            plane.setCapacity(capacity);
            plane.setFabricationDate(fabricationDate);
            plane.setIdModel(idModel);
            plane.setIdStatus(idStatus);

            createPlaneUseCase.createPlane(plane);

        } catch (Exception e) {
            System.out.println("Error al crear el avión");
        }
        System.out.println("Avión creado exitosamente.");
    }

    public void deletePlane() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese el id del Avión que desea eliminar: ");
            int idPlane = scanner.nextInt();
            scanner.nextLine();
    
            deletePlaneUseCase.deletePlane(idPlane);
    
            System.out.println("Avión eliminado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar el avión: " + e.getMessage());
        }
    }
    
    
}