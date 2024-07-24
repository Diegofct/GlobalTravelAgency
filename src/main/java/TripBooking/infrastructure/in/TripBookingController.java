package TripBooking.infrastructure.in;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import TripBooking.application.CreateTripBookingUseCase;
import TripBooking.application.DeleteTripBookingUseCase;
import TripBooking.application.ReadTripBookingUseCase;
import TripBooking.application.UpdateTripBookingUseCase;
import TripBooking.domain.entity.TripBooking;

public class TripBookingController {
    private final CreateTripBookingUseCase createTripBookingUseCase;
    private final DeleteTripBookingUseCase deleteTripBookingUseCase;
    private final ReadTripBookingUseCase readTripBookingUseCase;
    private final UpdateTripBookingUseCase updateTripBookingUseCase;

    public TripBookingController(CreateTripBookingUseCase createTripBookingUseCase,
            DeleteTripBookingUseCase deleteTripBookingUseCase, ReadTripBookingUseCase readTripBookingUseCase,
            UpdateTripBookingUseCase updateTripBookingUseCase) {
        this.createTripBookingUseCase = createTripBookingUseCase;
        this.deleteTripBookingUseCase = deleteTripBookingUseCase;
        this.readTripBookingUseCase = readTripBookingUseCase;
        this.updateTripBookingUseCase = updateTripBookingUseCase;
    }

    public void createTripBooking() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Registre el id de la reserva del vuelo");
            int idTripBooking = scanner.nextInt();
            scanner.nextLine();

            //Guardar formato fecha
            System.out.println("Registre la fecha del Trayecto (formato: yyyy-MM-dd): ");
            String dateTripBookingStr = scanner.nextLine();
            LocalDate dateTripBookingLocalDate = LocalDate.parse(dateTripBookingStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Date date = Date.valueOf(dateTripBookingLocalDate);

            System.out.println("Registre el id del Trayecto: ");
            int idTrip = scanner.nextInt();
            scanner.nextLine();

            TripBooking tripBooking = new TripBooking();
            tripBooking.setIdTripBooking(idTripBooking);
            tripBooking.setDate(date);
            tripBooking.setIdTrip(idTrip);

            createTripBookingUseCase.createTripBooking(tripBooking);


        } catch (Exception e) {
            System.out.println("Error al registrar la reserva del vuelo");
        }

        System.out.println("Se ha registrado la reserva de vuelo correctamente.");
    }

    public void readTripBooking() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese el id de la reserva del vuelo a consultar:");
            int idTripBooking = scanner.nextInt();
            scanner.nextLine();

            TripBooking tripBooking = readTripBookingUseCase.readTripBooking(idTripBooking);
            if (tripBooking != null) {
                System.out.println("ID de la reserva del vuelo: " + tripBooking.getIdTripBooking());
                System.out.println("Fecha de la reserva: " + tripBooking.getDate());
                System.out.println("ID del trayecto: " + tripBooking.getIdTrip());
            } else {
                System.out.println("Reserva de vuelo no encontrada.");
            }
        } catch (Exception e) {
            System.out.println("Error al consultar la reserva de vuelo: " + e.getMessage());
        }
    }
    
    public void updateTripBooking() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese el id de la reserva del vuelo a actualizar:");
            int idTripBooking = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Registre la nueva fecha de la reserva (formato: yyyy-MM-dd):");
            String dateTripBookingStr = scanner.nextLine();
            LocalDate dateTripBookingLocalDate = LocalDate.parse(dateTripBookingStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Date date = Date.valueOf(dateTripBookingLocalDate);

            System.out.println("Registre el nuevo id del Trayecto:");
            int idTrip = scanner.nextInt();
            scanner.nextLine();

            TripBooking tripBooking = new TripBooking();
            tripBooking.setIdTripBooking(idTripBooking);
            tripBooking.setDate(date);
            tripBooking.setIdTrip(idTrip);

            updateTripBookingUseCase.updateTripBooking(tripBooking);

        } catch (Exception e) {
            System.out.println("Error al actualizar la reserva de vuelo: " + e.getMessage());
        }

        System.out.println("Se ha actualizado la reserva de vuelo correctamente.");
    }

    public void deleteTripBooking() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese el id de la reserva del vuelo a eliminar:");
            int idTripBooking = scanner.nextInt();
            scanner.nextLine();

            deleteTripBookingUseCase.deleteTripBooking(idTripBooking);

        } catch (Exception e) {
            System.out.println("Error al eliminar la reserva de vuelo: " + e.getMessage());
        }

        System.out.println("Se ha eliminado la reserva de vuelo correctamente.");
    }
}
