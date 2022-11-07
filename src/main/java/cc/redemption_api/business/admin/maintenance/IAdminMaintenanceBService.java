package cc.redemption_api.business.admin.maintenance;

import java.util.Map;

public interface IAdminMaintenanceBService {
    Map loadExportData1(Map in) throws Exception;

    Map listSetting(Map in) throws Exception;

    void createSetting(Map in) throws Exception;

    void updateSetting(Map in) throws Exception;

    void deleteSetting(Map in) throws Exception;

    Map getSetting(Map in) throws Exception;
}
