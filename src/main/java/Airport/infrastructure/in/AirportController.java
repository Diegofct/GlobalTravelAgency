package Airport.infrastructure.in;

import java.util.Scanner;

import Airport.application.CreateAirportUseCase;
import Airport.application.DeleteAirportUseCase;
import Airport.application.GetAirportUseCase;
import Airport.application.GetAllAirportsUseCase;
import Airport.application.UpdateAirportUseCase;
import Airport.domain.entity.Airport;

public class AirportController {
    
    private final CreateAirportUseCase createAirportUseCase;
    private final DeleteAirportUseCase deleteAirportUseCase;
    private final GetAirportUseCase getAirportUseCase;
    private final GetAllAirportsUseCase getAllAirportsUseCase;
    private final UpdateAirportUseCase updateAirportUseCase;

    public AirportController(CreateAirportUseCase createAirportUseCase, DeleteAirportUseCase deleteAirportUseCase,
            GetAirportUseCase getAirportUseCase, GetAllAirportsUseCase getAllAirportsUseCase,
            UpdateAirportUseCase updateAirportUseCase) {
        this.createAirportUseCase = createAirportUseCase;
        this.deleteAirportUseCase = deleteAirportUseCase;
        this.getAirportUseCase = getAirportUseCase;
        this.getAllAirportsUseCase = getAllAirportsUseCase;
        this.updateAirportUseCase = updateAirportUseCase;
    }

    public void createAirport() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Digite el codigo del Aeropuerto: ");
            String idAirport = scanner.nextLine();
            
            System.out.println("Escriba el nombre del Aeropuerto: ");
            String name = scanner.nextLine();

            System.out.println("Ingrese el ID de la ciudad: ");
            String idCity = scanner.nextLine();

            Airport airport = new Airport();
            airport.setIdAirport(idAirport);
            airport.setName(name);
            airport.setIdCity(idCity);

            createAirportUseCase.createAirport(airport);

        } catch (Exception e) {
            System.out.println("Error al crear el aeropuerto");
        }
        System.out.println("Aeropuerto creado con exito");
    }

    
}
