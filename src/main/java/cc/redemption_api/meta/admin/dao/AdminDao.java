package cc.redemption_api.meta.admin.dao;

import cc.redemption_api.meta.admin.entity.Admin;
import cc.redemption_api.meta.admin.entity.AdminView;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.Map;

@Mapper
public interface AdminDao {
    /**
     * @param admin
     */
    void createAdmin(Admin admin);

    /**
     * @param qIn loginName
     *            token
     * @return
     */
    AdminView getAdmin(Map qIn);

    /**
     * @param qIn token
     *            tokenTime
     *            loginPassword
     *            adminId
     */
    void updateAdmin(Map qIn);

    ArrayList<AdminView> listAdmin(Map qIn);
}
