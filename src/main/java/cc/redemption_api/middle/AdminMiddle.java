package cc.redemption_api.middle;

import cc.redemption_api.meta.admin.entity.Admin;
import cc.redemption_api.meta.admin.entity.AdminView;
import cc.redemption_api.meta.admin.service.IAdminService;
import cc.redemption_api.meta.admin.service.IMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class AdminMiddle implements IAdminMiddle {
    private final IAdminService iAdminService;
    private final IMaintenanceService iMaintenanceService;

    public AdminMiddle(IAdminService iAdminService,
                       IMaintenanceService iMaintenanceService) {
        this.iAdminService = iAdminService;
        this.iMaintenanceService = iMaintenanceService;
    }

    @Override
    public void createAdmin(Admin admin) throws Exception {
        iAdminService.createAdmin(admin);
    }

    @Override
    public AdminView getAdmin(Map qIn, Boolean returnNull) throws Exception {
        AdminView adminView = iAdminService.getAdmin(qIn);
        if (adminView == null) {
            if (returnNull) {
                return null;
            }
            /**
             * 查询管理员错误
             */
            throw new Exception("10002");
        }
        return adminView;
    }

    @Override
    public void updateAdmin(Map qIn) throws Exception {
        iAdminService.updateAdmin(qIn);
    }

    @Override
    public ArrayList<AdminView> listAdmin(Map qIn) throws Exception {
        ArrayList<AdminView> adminViews = iAdminService.listAdmin(qIn);
        return adminViews;
    }

    @Override
    public ArrayList<Map> loadExportFile1(Map qIn) throws Exception {
        ArrayList<Map> out = iMaintenanceService.loadExportFile1(qIn);
        return out;
    }
}
