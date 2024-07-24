package TripBookingDetails.infrastructure.in;

import java.util.Scanner;

import TripBookingDetails.application.CreateTripBookingDetailsUseCase;
import TripBookingDetails.application.DeleteTripBookingDetailsUseCase;
import TripBookingDetails.application.ReadTripBookingDetailsUseCase;
import TripBookingDetails.application.UpdateTripBookingDetailsUseCase;
import TripBookingDetails.domain.entity.TripBookingDetails;

public class TripBookingDetailsController {
    private final CreateTripBookingDetailsUseCase createTripBookingDetailsUseCase;
    private final DeleteTripBookingDetailsUseCase deleteTripBookingDetailsUseCase;
    private final UpdateTripBookingDetailsUseCase updateTripBookingDetailsUseCase;
    private final ReadTripBookingDetailsUseCase readTripBookingDetailsUseCase;

    public TripBookingDetailsController(CreateTripBookingDetailsUseCase createTripBookingDetailsUseCase,
            DeleteTripBookingDetailsUseCase deleteTripBookingDetailsUseCase,
            UpdateTripBookingDetailsUseCase updateTripBookingDetailsUseCase,
            ReadTripBookingDetailsUseCase readTripBookingDetailsUseCase) {
        this.createTripBookingDetailsUseCase = createTripBookingDetailsUseCase;
        this.deleteTripBookingDetailsUseCase = deleteTripBookingDetailsUseCase;
        this.updateTripBookingDetailsUseCase = updateTripBookingDetailsUseCase;
        this.readTripBookingDetailsUseCase = readTripBookingDetailsUseCase;
    }

    public void createTripBookingDetails() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Registre el id de los detalles de la reserva del vuelo");
            int idTripBookingDetails = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Registre el id de la reserva del vuelo: ");
            int idTripBooking = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Registre el id del cliente: ");
            int idCustomer = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Registre el id de la tarifa del vuelo: ");
            int idFlightFare = scanner.nextInt();
            scanner.nextLine();

            TripBookingDetails tripBookingDetails = new TripBookingDetails();
            tripBookingDetails.setIdTripBookingDetails(idTripBookingDetails);
            tripBookingDetails.setIdTripBooking(idTripBooking);
            tripBookingDetails.setIdCustomer(idCustomer);
            tripBookingDetails.setIdFlightFare(idFlightFare);

            createTripBookingDetailsUseCase.createTripBookingDetails(tripBookingDetails);
        } catch (Exception e) {
            System.out.println("Error al registrar los detalles de la reserva del vuelo: " + e.getMessage());
        }

        System.out.println("Se han registrado los detalles de la reserva de vuelo correctamente.");
    }

    public void readTripBookingDetails() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese el id de los detalles de la reserva del vuelo a consultar:");
            int idTripBookingDetails = scanner.nextInt();
            scanner.nextLine();

            TripBookingDetails tripBookingDetails = readTripBookingDetailsUseCase.readTripBookingDetails(idTripBookingDetails);
            if (tripBookingDetails != null) {
                System.out.println("ID de los detalles de la reserva del vuelo: " + tripBookingDetails.getIdTripBookingDetails());
                System.out.println("ID de la reserva del vuelo: " + tripBookingDetails.getIdTripBooking());
                System.out.println("ID del cliente: " + tripBookingDetails.getIdCustomer());
                System.out.println("ID de la tarifa del vuelo: " + tripBookingDetails.getIdFlightFare());
            } else {
                System.out.println("Detalles de la reserva de vuelo no encontrados.");
            }
        } catch (Exception e) {
            System.out.println("Error al consultar los detalles de la reserva de vuelo: " + e.getMessage());
        }
    }

    public void updateTripBookingDetails() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese el id de los detalles de la reserva del vuelo a actualizar:");
            int idTripBookingDetails = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Registre el nuevo id de la reserva del vuelo: ");
            int idTripBooking = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Registre el nuevo id del cliente: ");
            int idCustomer = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Registre el nuevo id de la tarifa del vuelo: ");
            int idFlightFare = scanner.nextInt();
            scanner.nextLine();

            TripBookingDetails tripBookingDetails = new TripBookingDetails();
            tripBookingDetails.setIdTripBookingDetails(idTripBookingDetails);
            tripBookingDetails.setIdTripBooking(idTripBooking);
            tripBookingDetails.setIdCustomer(idCustomer);
            tripBookingDetails.setIdFlightFare(idFlightFare);

            updateTripBookingDetailsUseCase.updateTripBookingDetails(tripBookingDetails);
        } catch (Exception e) {
            System.out.println("Error al actualizar los detalles de la reserva de vuelo: " + e.getMessage());
        }

        System.out.println("Se han actualizado los detalles de la reserva de vuelo correctamente.");
    }

    public void deleteTripBookingDetails() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese el id de los detalles de la reserva del vuelo a eliminar:");
            int idTripBookingDetails = scanner.nextInt();
            scanner.nextLine();

            deleteTripBookingDetailsUseCase.deleteTripBookingDetails(idTripBookingDetails);
        } catch (Exception e) {
            System.out.println("Error al eliminar los detalles de la reserva de vuelo: " + e.getMessage());
        }

        System.out.println("Se han eliminado los detalles de la reserva de vuelo correctamente.");
    }
}
