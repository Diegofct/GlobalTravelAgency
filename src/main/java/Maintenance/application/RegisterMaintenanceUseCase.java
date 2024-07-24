package Maintenance.application;

import Maintenance.domain.entity.Maintenance;
import Maintenance.domain.service.MaintenanceService;

public class RegisterMaintenanceUseCase {
    private final MaintenanceService maintenanceService;

    

    public RegisterMaintenanceUseCase(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    public void registerMaintenance(Maintenance maintenance){
        maintenanceService.registerMaintenance(maintenance);
    }
}
