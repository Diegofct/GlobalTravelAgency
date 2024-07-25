package Plane.infrastructure.in;

import java.util.Scanner;

import Utils.MyUtils;

public class PlaneController {
    
    // obtener todas las vistas
    private final CreatePlaneView createPlaneView;
    private final DeletePlaneView deletePlaneView;
    private final FindPlaneView findPlaneView;
    private final GetPlanesView getPlanesView;
    private final Scanner scanner;

    // constructor
    public PlaneController(Scanner scanner){
        // obtener el scanner
        this.scanner = scanner;
        // inicializar las vistas
        this.createPlaneView = new CreatePlaneView(scanner);
        this.deletePlaneView = new DeletePlaneView(scanner);
        this.findPlaneView = new FindPlaneView(scanner);
        this.getPlanesView = new GetPlanesView();
    }

    public void run() {
        while (true) { 
            try {
                // mostrar el menu y obtener decision
                int decision = showMenu(scanner);

                // switch
                switch (decision) {
                    case 1:
                        MyUtils.displayMessageAndClearScreen("Cargando...", 1);
                        createPlaneView.start(); // iniciar vista
                        break;
                    case 2:
                        MyUtils.displayMessageAndClearScreen("Cargando...", 1);
                        deletePlaneView.start(); // iniciar vista
                        break;
                    case 3:
                        MyUtils.displayMessageAndClearScreen("Cargando...", 1);
                        findPlaneView.start(); // iniciar vista
                        break;
                    case 4:
                        MyUtils.displayMessageAndClearScreen("Cargando...", 1);
                        getPlanesView.start(); // iniciar vista
                        break;
                    case 5:
                        MyUtils.displayMessageAndClearScreen("Saliendo...", 1);
                        return;
                    default:
                        MyUtils.displayMessageAndClearScreen("Ups! decision incorrecta.", 2);
                        break;
                }
            } catch (Exception e) {
                
            }
        }
    }

    // metodo privado para mostrar el menu
    private int showMenu(Scanner scanner) {
        System.out.println("SECCION AVIONES");
        System.out.println("1. crear");
        System.out.println("2. eliminar");
        System.out.println("3. buscar");
        System.out.println("4. listar");
        System.out.println("5. salir");

        int option = scanner.nextInt();
        scanner.nextLine();

        return option;
    }
    
}