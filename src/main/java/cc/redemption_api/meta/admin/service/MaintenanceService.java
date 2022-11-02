package cc.redemption_api.meta.admin.service;

import cc.redemption_api.meta.admin.dao.MaintenanceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class MaintenanceService implements IMaintenanceService {
    private final MaintenanceDao maintenanceDao;

    public MaintenanceService(MaintenanceDao maintenanceDao) {
        this.maintenanceDao = maintenanceDao;
    }

    @Override
    public ArrayList<Map> loadExportFile1(Map qIn) throws Exception {
        ArrayList<Map> out = maintenanceDao.loadExportFile1(qIn);
        return out;
    }
}
