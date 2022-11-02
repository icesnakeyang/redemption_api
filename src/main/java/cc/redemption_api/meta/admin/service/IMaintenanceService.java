package cc.redemption_api.meta.admin.service;

import java.util.ArrayList;
import java.util.Map;

public interface IMaintenanceService {
    ArrayList<Map> loadExportFile1(Map qIn) throws Exception;
}
