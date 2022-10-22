package cc.redemption_api.middle;

import cc.redemption_api.meta.admin.entity.Admin;
import cc.redemption_api.meta.admin.entity.AdminView;
import cc.redemption_api.meta.admin.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AdminMiddle implements IAdminMiddle {
    private final IAdminService iAdminService;

    public AdminMiddle(IAdminService iAdminService) {
        this.iAdminService = iAdminService;
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
}
