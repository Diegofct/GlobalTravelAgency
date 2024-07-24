package Trip.infrastructure.in;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.util.Scanner;

import Trip.application.CreateTripUseCase;
import Trip.application.DeleteTripUseCase;
import Trip.application.ReadTripUseCase;
import Trip.application.UpdateTripUseCase;
import Trip.domain.entity.Trip;

public class TripController {
    private final CreateTripUseCase createTripUseCase;
    private final DeleteTripUseCase deleteTripUseCase;
    private final ReadTripUseCase readTripUseCase;
    private final UpdateTripUseCase updateTripUseCase;

    public TripController(CreateTripUseCase createTripUseCase, DeleteTripUseCase deleteTripUseCase,
            ReadTripUseCase readTripUseCase, UpdateTripUseCase updateTripUseCase) {
        this.createTripUseCase = createTripUseCase;
        this.deleteTripUseCase = deleteTripUseCase;
        this.readTripUseCase = readTripUseCase;
        this.updateTripUseCase = updateTripUseCase;
    }

    public void createTrip() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Registre el id del Trayecto: ");
            int idTrip = scanner.nextInt();
            scanner.nextLine();

            //Guardar formato fecha
            System.out.println("Registre la fecha del Trayecto (formato: yyyy-MM-dd): ");
            String dateTripStr = scanner.nextLine();
            LocalDate dateTripLocalDate = LocalDate.parse(dateTripStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Date dateTrip = Date.valueOf(dateTripLocalDate);

            System.out.println("Registre el valor del precio del Trayecto: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Registre la ciudad de origen: ");
            String originCity = scanner.nextLine();

            System.out.println("Registre la ciudad de destino: ");
            String destinationCity = scanner.nextLine();

            Trip trip = new Trip();
            trip.setIdTrip(idTrip);
            trip.setDateTrip(dateTrip);
            trip.setPrice(price);
            trip.setOriginCity(originCity);
            trip.setDestinationCity(destinationCity);

            createTripUseCase.createTrip(trip);

        } catch (Exception e) {
            System.out.println("Error al registrar trayecto");
        }
        System.out.println("Trayecto registrado con exito");
    }

    public void readTrip() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese el id del Trayecto a consultar: ");
            int idTrip = scanner.nextInt();
            scanner.nextLine();

            Trip trip = readTripUseCase.readTrip(idTrip);
            if (trip != null) {
                System.out.println("ID del Trayecto: " + trip.getIdTrip());
                System.out.println("Fecha del Trayecto: " + trip.getDateTrip());
                System.out.println("Precio del Trayecto: " + trip.getPrice());
                System.out.println("Ciudad de Origen: " + trip.getOriginCity());
                System.out.println("Ciudad de Destino: " + trip.getDestinationCity());
            } else {
                System.out.println("Trayecto no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Error al consultar el trayecto: " + e.getMessage());
        }
    }

    public void updateTrip() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese el id del Trayecto a actualizar: ");
            int idTrip = scanner.nextInt();
            scanner.nextLine();

            Trip existingTrip = readTripUseCase.readTrip(idTrip);
            if (existingTrip == null) {
                System.out.println("Trayecto no encontrado.");
                return;
            }

            System.out.println("Registre la nueva fecha del Trayecto (formato: yyyy-MM-dd): ");
            String dateTripStr = scanner.nextLine();
            LocalDate dateTripLocalDate = LocalDate.parse(dateTripStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Date dateTrip = Date.valueOf(dateTripLocalDate);

            System.out.println("Registre el nuevo valor del precio del Trayecto: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Registre la nueva ciudad de origen: ");
            String originCity = scanner.nextLine();

            System.out.println("Registre la nueva ciudad de destino: ");
            String destinationCity = scanner.nextLine();

            Trip updatedTrip = new Trip();
            updatedTrip.setIdTrip(idTrip);
            updatedTrip.setDateTrip(dateTrip);
            updatedTrip.setPrice(price);
            updatedTrip.setOriginCity(originCity);
            updatedTrip.setDestinationCity(destinationCity);

            updateTripUseCase.updateTrip(updatedTrip);

        } catch (Exception e) {
            System.out.println("Error al actualizar el trayecto: " + e.getMessage());
        }
        System.out.println("Trayecto actualizado con éxito.");
    }

    public void deleteTrip() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese el id del Trayecto a eliminar: ");
            int idTrip = scanner.nextInt();
            scanner.nextLine();

            Trip existingTrip = readTripUseCase.readTrip(idTrip);
            if (existingTrip == null) {
                System.out.println("Trayecto no encontrado.");
                return;
            }

            deleteTripUseCase.deleteTrip(idTrip);
            System.out.println("Trayecto eliminado con éxito.");
        } catch (Exception e) {
            System.out.println("Error al eliminar el trayecto: " + e.getMessage());
        }
    }

    
}
