package cc.redemption_api.middle;

import cc.redemption_api.meta.admin.entity.Admin;
import cc.redemption_api.meta.admin.entity.AdminView;

import java.util.ArrayList;
import java.util.Map;

public interface IAdminMiddle {
    /**
     * @param admin
     */
    void createAdmin(Admin admin) throws Exception;

    /**
     * @param qIn loginName
     *            token
     * @return
     */
    AdminView getAdmin(Map qIn, Boolean returnNull) throws Exception;

    /**
     * @param qIn token
     *            tokenTime
     *            loginPassword
     *            adminId
     */
    void updateAdmin(Map qIn) throws Exception;

    ArrayList<AdminView> listAdmin(Map qIn) throws Exception;

    ArrayList<Map> loadExportFile1(Map qIn) throws Exception;
}
