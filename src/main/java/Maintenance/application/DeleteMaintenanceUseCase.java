package Maintenance.application;

import Maintenance.domain.entity.Maintenance;
import Maintenance.domain.service.MaintenanceService;

public class DeleteMaintenanceUseCase {
    private final MaintenanceService maintenanceService;

    public DeleteMaintenanceUseCase(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    public void execute(int idRevision){
        maintenanceService.deleteMaintenance(idRevision);
    }

    public void deleteIdRevision(Maintenance maintenance) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteIdRevision'");
    }
}
