package cc.redemption_api.meta.admin.service;

import cc.redemption_api.meta.admin.dao.AdminDao;
import cc.redemption_api.meta.admin.entity.Admin;
import cc.redemption_api.meta.admin.entity.AdminView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class AdminService implements IAdminService {
    private final AdminDao adminDao;

    public AdminService(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public void createAdmin(Admin admin) throws Exception {
        adminDao.createAdmin(admin);
    }

    @Override
    public AdminView getAdmin(Map qIn) throws Exception {
        AdminView adminView = adminDao.getAdmin(qIn);
        return adminView;
    }

    @Override
    public void updateAdmin(Map qIn) throws Exception {
        adminDao.updateAdmin(qIn);
    }

    @Override
    public ArrayList<AdminView> listAdmin(Map qIn) throws Exception {
        ArrayList<AdminView> adminViews = adminDao.listAdmin(qIn);
        return adminViews;
    }
}
