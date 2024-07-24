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
import FlightConnection.application.CreateFlightConnectionUseCase;
import FlightConnection.application.DeleteFlightConnectionUseCase;
import FlightConnection.application.ReadFlightConnectionUseCase;
import FlightConnection.application.UpdateFlightConnectionUseCase;
import FlightConnection.domain.service.FlightConnectionService;
import FlightConnection.infrastructure.in.FlightConnectionController;
import FlightConnection.infrastructure.out.FlightConnectionRepository;
import FlightFare.application.CreateFlightFareUseCase;
import FlightFare.application.DeleteFlightFareUseCase;
import FlightFare.application.ReadFlightFareUseCase;
import FlightFare.application.UpdateFlightFareUseCase;
import FlightFare.domain.service.FlightFareService;
import FlightFare.infrastructure.in.FlightFareController;
import FlightFare.infrastructure.out.FlightFareRepository;
import Menu.MainMenu;
import Plane.application.CreatePlaneUseCase;
import Plane.application.DeletePlaneUseCase;
import Plane.application.FindPlaneUseCase;
import Plane.application.ListPlaneUseCase;
import Plane.application.UpdatePlaneUseCase;
import Plane.domain.service.PlaneService;
import Plane.infrastructure.in.PlaneController;
import Plane.infrastructure.out.PlaneRepository;
import Trip.application.CreateTripUseCase;
import Trip.application.DeleteTripUseCase;
import Trip.application.ReadTripUseCase;
import Trip.application.UpdateTripUseCase;
import Trip.domain.service.TripService;
import Trip.infrastructure.in.TripController;
import Trip.infrastructure.out.TripRepository;
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
                case 9:
                    System.out.println("Informacion Trayecto");
                    TripService tripService = new TripRepository();
                    CreateTripUseCase createTripUseCase = new CreateTripUseCase(tripService);
                    UpdateTripUseCase updateTripUseCase = new UpdateTripUseCase(tripService);
                    ReadTripUseCase readTripUseCase = new ReadTripUseCase(tripService);
                    DeleteTripUseCase deleteTripUseCase = new DeleteTripUseCase(tripService);
                    TripController tripController = new TripController(createTripUseCase, deleteTripUseCase, readTripUseCase, updateTripUseCase);
                    MainMenu.limpiarPantalla();
                    tripController.readTrip();
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
                case 18:
                    System.out.println("Actualizar información del Trayecto");
                    TripService tripService2 = new TripRepository();
                    CreateTripUseCase createTripUseCase2 = new CreateTripUseCase(tripService2);
                    UpdateTripUseCase updateTripUseCase2 = new UpdateTripUseCase(tripService2);
                    ReadTripUseCase readTripUseCase2 = new ReadTripUseCase(tripService2);
                    DeleteTripUseCase deleteTripUseCase2 = new DeleteTripUseCase(tripService2);
                    TripController tripController2 = new TripController(createTripUseCase2, deleteTripUseCase2, readTripUseCase2, updateTripUseCase2);
                    MainMenu.limpiarPantalla();
                    tripController2.updateTrip();
                    break;
                case 19:
                    System.out.println("Eliminar Trayecto");
                    TripService tripService3 = new TripRepository();
                    CreateTripUseCase createTripUseCase3  = new CreateTripUseCase(tripService3);
                    UpdateTripUseCase updateTripUseCase3 = new UpdateTripUseCase(tripService3);
                    ReadTripUseCase readTripUseCase3 = new ReadTripUseCase(tripService3);
                    DeleteTripUseCase deleteTripUseCase3 = new DeleteTripUseCase(tripService3);
                    TripController tripController3 = new TripController(createTripUseCase3, deleteTripUseCase3, readTripUseCase3, updateTripUseCase3);
                    MainMenu.limpiarPantalla();
                    tripController3.deleteTrip();
                    break;
                case 27:
                    System.out.println("Consultar Escalas de un Trayecto");
                    FlightConnectionService flightConnectionService = new FlightConnectionRepository();
                    CreateFlightConnectionUseCase createFlightConnectionUseCase = new CreateFlightConnectionUseCase(flightConnectionService);
                    UpdateFlightConnectionUseCase updateFlightConnectionUseCase = new UpdateFlightConnectionUseCase(flightConnectionService);
                    ReadFlightConnectionUseCase readFlightConnectionUseCase = new ReadFlightConnectionUseCase(flightConnectionService);
                    DeleteFlightConnectionUseCase deleteFlightConnectionUseCase = new DeleteFlightConnectionUseCase(flightConnectionService);
                    FlightConnectionController flightConnectionController = new FlightConnectionController(createFlightConnectionUseCase, deleteFlightConnectionUseCase, readFlightConnectionUseCase, updateFlightConnectionUseCase);
                    MainMenu.limpiarPantalla();
                    flightConnectionController.readFlightConnection();
                    break;
                case 28:
                    System.out.println("Actualizar Información Escala");
                    FlightConnectionService flightConnectionService2 = new FlightConnectionRepository();
                    CreateFlightConnectionUseCase createFlightConnectionUseCase2 = new CreateFlightConnectionUseCase(flightConnectionService2);
                    UpdateFlightConnectionUseCase updateFlightConnectionUseCase2 = new UpdateFlightConnectionUseCase(flightConnectionService2);
                    ReadFlightConnectionUseCase readFlightConnectionUseCase2 = new ReadFlightConnectionUseCase(flightConnectionService2);
                    DeleteFlightConnectionUseCase deleteFlightConnectionUseCase2 = new DeleteFlightConnectionUseCase(flightConnectionService2);
                    FlightConnectionController flightConnectionController2 = new FlightConnectionController(createFlightConnectionUseCase2, deleteFlightConnectionUseCase2, readFlightConnectionUseCase2, updateFlightConnectionUseCase2);
                    MainMenu.limpiarPantalla();
                    flightConnectionController2.updateFlightConnection();
                    break;
                case 29:
                    System.out.println("Eliminar Escala");
                    FlightConnectionService flightConnectionService3 = new FlightConnectionRepository();
                    CreateFlightConnectionUseCase createFlightConnectionUseCase3 = new CreateFlightConnectionUseCase(flightConnectionService3);
                    UpdateFlightConnectionUseCase updateFlightConnectionUseCase3 = new UpdateFlightConnectionUseCase(flightConnectionService3);
                    ReadFlightConnectionUseCase readFlightConnectionUseCase3 = new ReadFlightConnectionUseCase(flightConnectionService3);
                    DeleteFlightConnectionUseCase deleteFlightConnectionUseCase3 = new DeleteFlightConnectionUseCase(flightConnectionService3);
                    FlightConnectionController flightConnectionController3 = new FlightConnectionController(createFlightConnectionUseCase3, deleteFlightConnectionUseCase3, readFlightConnectionUseCase3, updateFlightConnectionUseCase3);
                    MainMenu.limpiarPantalla();
                    flightConnectionController3.deleteFlightConnection();
                    break;
                case 30:
                    System.out.println("Registrar Tarifa de Vuelo");
                    FlightFareService flightFareService = new FlightFareRepository();
                    CreateFlightFareUseCase createFlightFareUseCase = new CreateFlightFareUseCase(flightFareService);
                    UpdateFlightFareUseCase updateFlightFareUseCase = new UpdateFlightFareUseCase(flightFareService);
                    ReadFlightFareUseCase readFlightFareUseCase = new ReadFlightFareUseCase(flightFareService);
                    DeleteFlightFareUseCase deleteFlightFareUseCase = new DeleteFlightFareUseCase(flightFareService);
                    FlightFareController flightFareController = new FlightFareController(createFlightFareUseCase, deleteFlightFareUseCase, readFlightFareUseCase, updateFlightFareUseCase);
                    MainMenu.limpiarPantalla();
                    flightFareController.createFlightFare();
                    break;
                case 31:
                    System.out.println("Actualizar información de las Tarifas de vuelos");
                    FlightFareService flightFareService2 = new FlightFareRepository();
                    CreateFlightFareUseCase createFlightFareUseCase2 = new CreateFlightFareUseCase(flightFareService2);
                    UpdateFlightFareUseCase updateFlightFareUseCase2 = new UpdateFlightFareUseCase(flightFareService2);
                    ReadFlightFareUseCase readFlightFareUseCase2 = new ReadFlightFareUseCase(flightFareService2);
                    DeleteFlightFareUseCase deleteFlightFareUseCase2 = new DeleteFlightFareUseCase(flightFareService2);
                    FlightFareController flightFareController2 = new FlightFareController(createFlightFareUseCase2, deleteFlightFareUseCase2, readFlightFareUseCase2, updateFlightFareUseCase2);
                    MainMenu.limpiarPantalla();
                    flightFareController2.updateFlightFare();
                    break;
                case 32:
                    System.out.println("Eliminar Tarifa de vuelo");
                    FlightFareService flightFareService3 = new FlightFareRepository();
                    CreateFlightFareUseCase createFlightFareUseCase3 = new CreateFlightFareUseCase(flightFareService3);
                    UpdateFlightFareUseCase updateFlightFareUseCase3 = new UpdateFlightFareUseCase(flightFareService3);
                    ReadFlightFareUseCase readFlightFareUseCase3 = new ReadFlightFareUseCase(flightFareService3);
                    DeleteFlightFareUseCase deleteFlightFareUseCase3 = new DeleteFlightFareUseCase(flightFareService3);
                    FlightFareController flightFareController3 = new FlightFareController(createFlightFareUseCase3, deleteFlightFareUseCase3, readFlightFareUseCase3, updateFlightFareUseCase3);
                    MainMenu.limpiarPantalla();
                    flightFareController3.deleteFlightFare();
                    break;
                case 33:
                    System.out.println("Consultar Tarifas de vuelo");
                    FlightFareService flightFareService4 = new FlightFareRepository();
                    CreateFlightFareUseCase createFlightFareUseCase4 = new CreateFlightFareUseCase(flightFareService4);
                    UpdateFlightFareUseCase updateFlightFareUseCase4 = new UpdateFlightFareUseCase(flightFareService4);
                    ReadFlightFareUseCase readFlightFareUseCase4 = new ReadFlightFareUseCase(flightFareService4);
                    DeleteFlightFareUseCase deleteFlightFareUseCase4 = new DeleteFlightFareUseCase(flightFareService4);
                    FlightFareController flightFareController4 = new FlightFareController(createFlightFareUseCase4, deleteFlightFareUseCase4, readFlightFareUseCase4, updateFlightFareUseCase4);
                    MainMenu.limpiarPantalla();
                    flightFareController4.readFlightFare();
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