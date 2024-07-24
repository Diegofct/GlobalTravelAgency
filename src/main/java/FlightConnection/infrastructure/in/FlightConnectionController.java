package FlightConnection.infrastructure.in;

import java.util.Scanner;

import FlightConnection.application.CreateFlightConnectionUseCase;
import FlightConnection.application.DeleteFlightConnectionUseCase;
import FlightConnection.application.ReadFlightConnectionUseCase;
import FlightConnection.application.UpdateFlightConnectionUseCase;
import FlightConnection.domain.entity.FlightConnection;

public class FlightConnectionController {
    private final CreateFlightConnectionUseCase createFlightConnectionUseCase;
    private final DeleteFlightConnectionUseCase deleteFlightConnectionUseCase;
    private final ReadFlightConnectionUseCase readFlightConnectionUseCase;
    private final UpdateFlightConnectionUseCase updateFlightConnectionUseCase;

    public FlightConnectionController(CreateFlightConnectionUseCase createFlightConnectionUseCase,
            DeleteFlightConnectionUseCase deleteFlightConnectionUseCase,
            ReadFlightConnectionUseCase readFlightConnectionUseCase,
            UpdateFlightConnectionUseCase updateFlightConnectionUseCase) {
        this.createFlightConnectionUseCase = createFlightConnectionUseCase;
        this.deleteFlightConnectionUseCase = deleteFlightConnectionUseCase;
        this.readFlightConnectionUseCase = readFlightConnectionUseCase;
        this.updateFlightConnectionUseCase = updateFlightConnectionUseCase;
    }

    public void createFlightConnection() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese el id de la conexión del vuelo(Escala): ");
            int idFlightConnection = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese el número de la conexión del vuelo(Escala): ");
            String connectionNumber = scanner.nextLine();

            System.out.println("Ingrese el id del viaje: ");
            int idTrip = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese el id del avión: ");
            int idPlane = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese el id del aeropuerto: ");
            String idAirport = scanner.nextLine();

            FlightConnection flightConnection = new FlightConnection();
            flightConnection.setIdFlightConnection(idFlightConnection);
            flightConnection.setConnectionNumber(connectionNumber);
            flightConnection.setIdTrip(idTrip);
            flightConnection.setIdPlane(idPlane);
            flightConnection.setIdAirport(idAirport);

            createFlightConnectionUseCase.createFlightConnection(flightConnection);

        } catch (Exception e) {
            System.out.println("Error al registrar la conexión del vuelo: " + e.getMessage());
        }
        System.out.println("La conexión del vuelo se ha registrado correctamente.");
    }

    public void readFlightConnection() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese el id de la conexión del vuelo a consultar: ");
            int idFlightConnection = scanner.nextInt();
            scanner.nextLine();

            FlightConnection flightConnection = readFlightConnectionUseCase.readFlightConnection(idFlightConnection);
            if (flightConnection != null) {
                System.out.println("ID de la Conexión del Vuelo: " + flightConnection.getIdFlightConnection());
                System.out.println("Número de Conexión: " + flightConnection.getConnectionNumber());
                System.out.println("ID del Viaje: " + flightConnection.getIdTrip());
                System.out.println("ID del Avión: " + flightConnection.getIdPlane());
                System.out.println("ID del Aeropuerto: " + flightConnection.getIdAirport());
            } else {
                System.out.println("Conexión del vuelo no encontrada.");
            }
        } catch (Exception e) {
            System.out.println("Error al consultar la conexión del vuelo: " + e.getMessage());
        }
    }

    public void updateFlightConnection() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese el id de la conexión del vuelo a actualizar: ");
            int idFlightConnection = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese el nuevo número de conexión del vuelo: ");
            String connectionNumber = scanner.nextLine();

            System.out.println("Ingrese el nuevo id del viaje: ");
            int idTrip = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese el nuevo id del avión: ");
            int idPlane = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese el nuevo id del aeropuerto: ");
            String idAirport = scanner.nextLine();

            FlightConnection flightConnection = new FlightConnection();
            flightConnection.setIdFlightConnection(idFlightConnection);
            flightConnection.setConnectionNumber(connectionNumber);
            flightConnection.setIdTrip(idTrip);
            flightConnection.setIdPlane(idPlane);
            flightConnection.setIdAirport(idAirport);

            updateFlightConnectionUseCase.updateFlightConnection(flightConnection);

        } catch (Exception e) {
            System.out.println("Error al actualizar la conexión del vuelo: " + e.getMessage());
        }
        System.out.println("La conexión del vuelo se ha actualizado correctamente.");
    }

    public void deleteFlightConnection() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese el id de la conexión del vuelo a eliminar: ");
            int idFlightConnection = scanner.nextInt();
            scanner.nextLine();

            deleteFlightConnectionUseCase.deleteFlightConnection(idFlightConnection);
            System.out.println("La conexión del vuelo se ha eliminado correctamente.");

        } catch (Exception e) {
            System.out.println("Error al eliminar la conexión del vuelo: " + e.getMessage());
        }
    }
    
}
