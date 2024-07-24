package Maintenance.application;

import Maintenance.domain.entity.Maintenance;
import Maintenance.domain.service.MaintenanceService;

public class UpdateMaintenanceUseCase {
    private final MaintenanceService maintenanceService;

    public UpdateMaintenanceUseCase(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    public void updateMaintenance(Maintenance maintenance){
        maintenanceService.updateMaintenance(maintenance);
    }

    
    
}
