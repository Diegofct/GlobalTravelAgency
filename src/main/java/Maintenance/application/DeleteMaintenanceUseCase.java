package Maintenance.application;

import Maintenance.domain.service.MaintenanceService;

public class DeleteMaintenanceUseCase {
    private final MaintenanceService maintenanceService;

    public DeleteMaintenanceUseCase(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    public void deleteMaintenance(int idRevision){
        maintenanceService.deleteMaintenance(idRevision);
    }
}
