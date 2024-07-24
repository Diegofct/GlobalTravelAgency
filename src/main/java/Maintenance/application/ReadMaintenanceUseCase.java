package Maintenance.application;


import Maintenance.domain.entity.Maintenance;
import Maintenance.domain.service.MaintenanceService;

public class ReadMaintenanceUseCase {
    private final MaintenanceService maintenanceService;
    
    
    public ReadMaintenanceUseCase(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }


    public Maintenance readMaintenance(int idRevision){
        Maintenance maintenances = maintenanceService.readMaintenance(idRevision);
        return maintenances;
    }
}



        /*
        public Maintenance readMaintenance(int idMaintenance) {
        Maintenance maintenance = maintenanceService.(idMaintenance);
        return maintenance;
    }
         */