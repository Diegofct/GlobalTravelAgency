package Maintenance.application;

import Maintenance.domain.entity.Maintenance;
import Maintenance.domain.service.MaintenanceService;


public class ReadMaintenanceUseCase {
    private final MaintenanceService maintenanceService;

    public ReadMaintenanceUseCase(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    public Maintenance readMaintenance(int idMaintenance) {
        Maintenance maintenance = maintenanceService.readMaintenance(idMaintenance);
        return maintenance;
    }
}
