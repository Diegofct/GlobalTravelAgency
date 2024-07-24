/*package Maintenance.infrastructure.in;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Date;
import java.util.List;

import Maintenance.application.DeleteMaintenanceUseCase;
import Maintenance.application.ListPlainMaintenanceUseCase;
import Maintenance.application.ReadMaintenanceUseCase;
import Maintenance.application.RegisterMaintenanceUseCase;
import Maintenance.application.UpdateMaintenanceUseCase;
import Maintenance.domain.entity.Maintenance;

public class MaintenanceController {
    private final RegisterMaintenanceUseCase registerMaintenanceUseCase;
    private final DeleteMaintenanceUseCase deleteMaintenanceUseCase;
    private final ListPlainMaintenanceUseCase listPlainMaintenanceUseCase;
    private final UpdateMaintenanceUseCase updateMaintenanceUseCase;

    public MaintenanceController(RegisterMaintenanceUseCase registerMaintenanceUseCase, 
            DeleteMaintenanceUseCase deleteMaintenanceUseCase, 
            ListPlainMaintenanceUseCase listPlainMaintenanceUseCase, 
            UpdateMaintenanceUseCase updateMaintenanceUseCase) {
        this.registerMaintenanceUseCase = registerMaintenanceUseCase;
        this.deleteMaintenanceUseCase = deleteMaintenanceUseCase;
        this.listPlainMaintenanceUseCase = listPlainMaintenanceUseCase;
        this.updateMaintenanceUseCase = updateMaintenanceUseCase;
    }

    public void registerMaintenance() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Digite el id del mantenimiento");
            int idRevision = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese la fecha de la revisión (formato: yyyy-MM-dd): ");
            String revisionDateStr = scanner.nextLine();
            LocalDate maintenanceLocalDate = LocalDate.parse(revisionDateStr, 
                    DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Date maintenanceDate = Date.from(maintenanceLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

            System.out.println("Inserte el id del avión al cual se le realizó el mantenimiento");
            int idPlane = scanner.nextInt();
            scanner.nextLine();

            Maintenance maintenance = new Maintenance();
            maintenance.setIdRevision(idRevision);
            maintenance.setRevisionDate(maintenanceDate);
            maintenance.setIdPlane(idPlane);

            registerMaintenanceUseCase.registerMaintenance(maintenance);
            System.out.println("Mantenimiento registado con éxito");
        } catch (Exception d) {
            System.out.println("Error al registrar el mantenimiento para este avión");
        }
    }

    public void deleteMaintenance() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese el id del mantenimiento que desea eliminar");
            int idRevision = scanner.nextInt();
            scanner.nextLine();

            Maintenance maintenance = new Maintenance();
            maintenance.setIdRevision(idRevision);

            deleteMaintenanceUseCase.deleteIdRevision(maintenance);
            System.out.println("Mantenimiento eliminado con éxito! ");
        } catch (Exception m) {
            System.out.println("Error al eliminar el mantenimiento");
        }
    }

    public void listPlainMaintenance() {
        try {
            List<Maintenance> maintenances = ReadMaintenanceUseCase.ReadMaintenanceUseCase();
            if (maintenances != null) {
                System.out.println("Lista de mantenimientos:");
                for (Maintenance maintenance : maintenances) {
                    System.out.println("ID: " + maintenance.getIdRevision() + 
                                       ", Fecha: " + maintenance.getRevisionDate() + 
                                       ", Avión ID: " + maintenance.getIdPlane());
                }
            } else {
                System.out.println("No hay mantenimientos registrados");
            }
        } catch (Exception e) {
            System.out.println("Error al listar los mantenimientos: " + e.getMessage());
        }
    }

    public void updateMaintenance() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese el id del mantenimiento que desea actualizar:");
            int idRevision = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese la nueva fecha de la revisión (formato: yyyy-MM-dd): ");
            String revisionDateStr = scanner.nextLine();
            LocalDate maintenanceLocalDate = LocalDate.parse(revisionDateStr, 
                    DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Date maintenanceDate = Date.from(maintenanceLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

            System.out.println("Inserte el nuevo id del avión al cual se le realizó el mantenimiento:");
            int idPlane = scanner.nextInt();
            scanner.nextLine();

            Maintenance maintenance = new Maintenance();
            maintenance.setIdRevision(idRevision);
            maintenance.setRevisionDate(maintenanceDate);
            maintenance.setIdPlane(idPlane);

            updateMaintenanceUseCase.updateMaintenance(maintenance);
            System.out.println("Mantenimiento actualizado con éxito");
        } catch (Exception e) {
            System.out.println("Error al actualizar el mantenimiento: " + e.getMessage());
        }
    }
}

*/