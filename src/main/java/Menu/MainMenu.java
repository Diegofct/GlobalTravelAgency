package Menu;

import java.util.Scanner;

import User.application.UserUseCase;
import User.domain.service.UserService;
import User.infrastructure.in.UserController;
import User.infrastructure.out.UserRepository;

public class MainMenu {

    public void Start() {
        limpiarPantalla();

        try (Scanner scanner = new Scanner(System.in)) {
            int opcion;
            boolean exit = false;

            while (!exit){
                try {
                    System.out.println("======================================");
                    System.out.println("    ¡Bienvenido a Vuelos Globales!    ");
                    System.out.println("======================================");
                    System.out.println("1. Iniciar sesión");
                    System.out.println("2. Registrarse");
                    System.out.println("3. Salir");
                    System.out.println("======================================");
                    System.out.print("Elija una opción: ");

                    opcion = scanner.nextInt();
                    scanner.nextLine(); 

                    switch (opcion) {
                        case 1:
                            System.out.println("Iniciando sesión...");
                            UserService userService = new UserRepository();
                            UserUseCase userUseCase = new UserUseCase(userService);
                            UserController userController = new UserController(userUseCase);
                            limpiarPantalla();
                            userController.loginUser();                
                            break;
                        case 2:
                            System.out.println("Registrándose...");
                            UserService userService2 = new UserRepository();
                            UserUseCase userUseCase2 = new UserUseCase(userService2);
                            UserController userController2 = new UserController(userUseCase2);
                            limpiarPantalla();
                            userController2.createUser();
                            break;
                        case 3:
                            System.out.println("Saliendo...");
                            exit = true;
                            break;
                        default:
                            System.out.println("Opción no válida.");
                            break;
                    }
                }  catch (Exception e) {
                    System.out.println("======================================");
                    System.out.println("Formato invalido. Inserta un número!");
                    System.out.println("======================================");
                    scanner.nextLine();
                }
            }
        }

    }

    
    public static void limpiarPantalla() {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
    
    
}

