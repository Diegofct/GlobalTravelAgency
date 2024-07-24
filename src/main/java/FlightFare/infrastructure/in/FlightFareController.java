package FlightFare.infrastructure.in;

import java.util.Scanner;

import FlightFare.application.CreateFlightFareUseCase;
import FlightFare.application.DeleteFlightFareUseCase;
import FlightFare.application.ReadFlightFareUseCase;
import FlightFare.application.UpdateFlightFareUseCase;
import FlightFare.domain.entity.FlightFare;

public class FlightFareController {
    private final CreateFlightFareUseCase createFlightFareUseCase;
    private final DeleteFlightFareUseCase deleteFlightFareUseCase;
    private final ReadFlightFareUseCase readFlightFareUseCase;
    private final UpdateFlightFareUseCase updateFlightFareUseCase;

    public FlightFareController(CreateFlightFareUseCase createFlightFareUseCase,
            DeleteFlightFareUseCase deleteFlightFareUseCase, ReadFlightFareUseCase readFlightFareUseCase,
            UpdateFlightFareUseCase updateFlightFareUseCase) {
        this.createFlightFareUseCase = createFlightFareUseCase;
        this.deleteFlightFareUseCase = deleteFlightFareUseCase;
        this.readFlightFareUseCase = readFlightFareUseCase;
        this.updateFlightFareUseCase = updateFlightFareUseCase;
    }

    public void createFlightFare() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese el id de la tarifa del vuelo: ");
            int idFlightFare = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese la descripción de la tarifa del vuelo: ");
            String description = scanner.nextLine();

            System.out.println("Ingrese los detalles de la tarifa del vuelo: ");
            String details = scanner.nextLine();

            System.out.println("Ingrese el valor de la tarifa del vuelo: ");
            double value = scanner.nextDouble();
            scanner.nextLine();

            FlightFare flightFare = new FlightFare();
            flightFare.setIdFlightFare(idFlightFare);
            flightFare.setDescription(description);
            flightFare.setDetails(details);
            flightFare.setValue(value);

            createFlightFareUseCase.createFlightFare(flightFare);

        } catch (Exception e) {
            System.out.println("Error al registrar el precio del vuelo: " + e.getMessage());
        }
        System.out.println("El precio del vuelo se ha registrado correctamente.");
    }

    public void readFlightFare() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese el id de la tarifa del vuelo a consultar: ");
            int idFlightFare = scanner.nextInt();
            scanner.nextLine();

            FlightFare flightFare = readFlightFareUseCase.readFlightFare(idFlightFare);
            if (flightFare != null) {
                System.out.println("ID del Precio del Vuelo: " + flightFare.getIdFlightFare());
                System.out.println("Descripción: " + flightFare.getDescription());
                System.out.println("Detalles: " + flightFare.getDetails());
                System.out.println("Valor: " + flightFare.getValue());
            } else {
                System.out.println("Precio del vuelo no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Error al consultar el precio del vuelo: " + e.getMessage());
        }
    }

    public void updateFlightFare() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese el id de la tarifa del vuelo a actualizar: ");
            int idFlightFare = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese la nueva descripción de la tarifa del vuelo: ");
            String description = scanner.nextLine();

            System.out.println("Ingrese los nuevos detalles de la tarifa del vuelo: ");
            String details = scanner.nextLine();

            System.out.println("Ingrese el nuevo valor de la tarifa del vuelo: ");
            double value = scanner.nextDouble();
            scanner.nextLine();

            FlightFare flightFare = new FlightFare();
            flightFare.setIdFlightFare(idFlightFare);
            flightFare.setDescription(description);
            flightFare.setDetails(details);
            flightFare.setValue(value);

            updateFlightFareUseCase.updateFlightFare(flightFare);
            

        } catch (Exception e) {
            System.out.println("Error al actualizar el precio del vuelo: " + e.getMessage());
        }
        System.out.println("El precio del vuelo se ha actualizado correctamente.");
    }

    public void deleteFlightFare() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese el id de la tarifa del vuelo a eliminar: ");
            int idFlightFare = scanner.nextInt();
            scanner.nextLine();

            deleteFlightFareUseCase.deleteFlightFare(idFlightFare);
            System.out.println("La tarifa del vuelo se ha eliminado correctamente.");

        } catch (Exception e) {
            System.out.println("Error al eliminar la tarifa del vuelo: " + e.getMessage());
        }
    }

    
}
