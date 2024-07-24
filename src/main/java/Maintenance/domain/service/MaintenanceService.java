package Maintenance.domain.service;

import java.util.List;

import Maintenance.domain.entity.Maintenance;

public interface MaintenanceService {
    void registerMaintenance(Maintenance maintenance);
    void updateMaintenance(Maintenance maintenance);
    void deleteMaintenance(int idRevision);
    Maintenance readMaintenance(int idRevision);
}