package User.infrastructure.in;

import java.util.Scanner;

import Airport.application.CreateAirportUseCase;
import Airport.application.DeleteAirportUseCase;
import Airport.application.GetAirportUseCase;
import Airport.application.GetAllAirportsUseCase;
import Airport.application.UpdateAirportUseCase;
import Airport.domain.service.AirportService;
import Airport.infrastructure.in.AirportController;
import Airport.infrastructure.out.AirportRepository;
import Customer.application.CreateCustomerUseCase;
import Customer.application.UpdateCustomerUseCase;
import Customer.domain.service.CustomerService;
import Customer.infrastructure.in.CustomerController;
import Customer.infrastructure.out.CustomerRepository;
import DocumentType.application.CreateDocumentTypeUseCase;
import DocumentType.application.DeleteDocumentTypeUseCase;
import DocumentType.application.ReadDocumentTypeUseCase;
import DocumentType.application.UpdateDocumentTypeUseCase;
import DocumentType.domain.service.DocumentTypeService;
import DocumentType.infrastructure.in.DocumentTypeController;
import DocumentType.infrastructure.out.DocumentTypeRepository;
import Menu.MainMenu;
import Plane.application.CreatePlaneUseCase;
import Plane.application.DeletePlaneUseCase;
import Plane.application.FindPlaneUseCase;
import Plane.application.ListPlaneUseCase;
import Plane.application.UpdatePlaneUseCase;
import Plane.domain.service.PlaneService;
import Plane.infrastructure.in.PlaneController;
import Plane.infrastructure.out.PlaneRepository;
import User.application.UserUseCase;
import User.domain.entity.Permission;
import User.domain.entity.User;

public class UserController {
    private final UserUseCase userUseCase;

    public UserController(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    public void loginUser(){
        Scanner scanner = new Scanner(System.in);
        try {

            System.out.println("Digite el nombre de usuario: ");
            String username = scanner.nextLine();

            System.out.println("Digite la contraseña: ");
            String password = scanner.nextLine();

            User user = userUseCase.findUser(username, password);
            if (user != null) {
                System.out.println("Usuario si existe");
                showUserMenu(user);
            } else {
                System.out.println("No se encontró el usuario");
            }
        } catch (Exception e ){
            System.out.println("Excepcion de loginUser");
        }

    }

    public void createUser() {
        Scanner scanner = new Scanner(System.in);
        try {

            System.out.println("Digite el id del Usuario: ");
            Long idUser = scanner.nextLong();
            scanner.nextLine();

            System.out.println("Digite el nombre de usuario: ");
            String username = scanner.nextLine();

            System.out.println("Digite el email: ");
            String email = scanner.nextLine();

            System.out.println("Cree una contraseña");
            String password = scanner.nextLine();

            System.out.println("Digite el id del Rol para el usuario: ");
            int idRole = scanner.nextInt();
            scanner.nextLine();

            User user = new User();
            user.setIdUser(idUser);
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            user.setIdRole(idRole);

            userUseCase.createUser(user);
        } catch (Exception e) {
            System.out.println("Problemas en Crear usuario");
        }

        System.out.println("Usuario creado con exito!");
    }

    private void showUserMenu(User user) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
    
        while (!exit) {
            System.out.println("======================================");
            System.out.println("          Menú Principal             ");
            System.out.println("======================================");
    
            // Mostrar permisos del usuario
            for (Permission permission : user.getPermissions()) {
                System.out.println(permission.getIdPermission() + ". " + permission.getDescription());
            }
            System.out.println("0. Salir");
            System.out.println("======================================");
            System.out.print("Elija una opción: ");
    
            int opcion = scanner.nextInt();
            scanner.nextLine();
    
            if (opcion == 0) {
                exit = true;
                MainMenu.limpiarPantalla();
            } else {
                // Manejar las opciones seleccionadas
                handleUserOption(opcion, user);
            }
        }
    }
    
    private void handleUserOption(int option, User user) {
        Permission selectedPermission = null;
        for (Permission permission : user.getPermissions()) {
            if (permission.getIdPermission() == option) {
                selectedPermission = permission;
                break;
            }
        }

        if (selectedPermission != null) {
            switch (selectedPermission.getIdPermission()) {
                case 1:
                    System.out.println("Registrar Avion");
                    PlaneService planeService = new PlaneRepository();
                    CreatePlaneUseCase createPlaneUseCase = new CreatePlaneUseCase(planeService);
                    DeletePlaneUseCase deletePlaneUseCase = new DeletePlaneUseCase(planeService);
                    FindPlaneUseCase findPlaneUseCase = new FindPlaneUseCase(planeService);
                    ListPlaneUseCase listPlaneUseCase = new ListPlaneUseCase(planeService);
                    UpdatePlaneUseCase updatePlaneUseCase = new UpdatePlaneUseCase(planeService);
                    PlaneController planeController = new PlaneController(createPlaneUseCase, deletePlaneUseCase, findPlaneUseCase, listPlaneUseCase, updatePlaneUseCase);
                    MainMenu.limpiarPantalla();
                    planeController.createPlane();
                    break;
                case 2:
                    System.out.println("Registrar Avion");
                    // assignCrewToJourney();
                    break;
                case 3:
                    System.out.println("Registrar Avion");
                    // createFlightReservation();
                    break;
                case 4:
                    System.out.println("Registrar Avion");
                    // registerMaintenanceReview();
                    break;
                case 5:
                    System.out.println("Registrar Avion");
                    // viewCustomerInformation();
                    break;
                case 6:
                    System.out.println("Registrar Avion");
                    // viewFlightReservation();
                    break;
                case 7:
                    System.out.println("Registrar Cliente");
                    CustomerService customerService = new CustomerRepository();
                    CreateCustomerUseCase createCustomerUseCase = new CreateCustomerUseCase(customerService);
                    UpdateCustomerUseCase updateCustomerUseCase = new UpdateCustomerUseCase(customerService);
                    CustomerController customerController = new CustomerController(createCustomerUseCase, updateCustomerUseCase);
                    MainMenu.limpiarPantalla();
                    customerController.createCustomer();
                    break;
                case 10:
                    System.out.println("Registrar Aeropuerto: ");
                    AirportService airportService = new AirportRepository();
                    CreateAirportUseCase createAirportUseCase = new CreateAirportUseCase(airportService);
                    DeleteAirportUseCase deleteAirportUseCase = new DeleteAirportUseCase(airportService);
                    GetAirportUseCase getAirportUseCase = new GetAirportUseCase(airportService);
                    GetAllAirportsUseCase getAllAirportsUseCase = new GetAllAirportsUseCase(airportService);
                    UpdateAirportUseCase updateAirportUseCase = new UpdateAirportUseCase(airportService);
                    AirportController airportController = new AirportController(createAirportUseCase, deleteAirportUseCase, getAirportUseCase, getAllAirportsUseCase, updateAirportUseCase);
                    MainMenu.limpiarPantalla();
                    airportController.createAirport();
                    break;
                case 34:
                    System.out.println("Registrar el tipo de Documento: ");
                    DocumentTypeService documentTypeService = new DocumentTypeRepository();
                    CreateDocumentTypeUseCase createDocumentTypeUseCase = new CreateDocumentTypeUseCase(documentTypeService);
                    DeleteDocumentTypeUseCase deleteDocumentTypeUseCase = new DeleteDocumentTypeUseCase(documentTypeService);
                    ReadDocumentTypeUseCase readDocumentTypeUseCase = new ReadDocumentTypeUseCase(documentTypeService);
                    UpdateDocumentTypeUseCase updateDocumentTypeUseCase = new UpdateDocumentTypeUseCase(documentTypeService);
                    DocumentTypeController documentTypeController = new DocumentTypeController(createDocumentTypeUseCase, deleteDocumentTypeUseCase, readDocumentTypeUseCase, updateDocumentTypeUseCase);
                    MainMenu.limpiarPantalla();
                    documentTypeController.createDocumentType();
                    break;
                // Agrega los demás casos según los permisos necesarios
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } else {
            System.out.println("No tiene permiso para realizar esta acción.");
        }
    }
}