package cc.redemption_api.business.admin;

import cc.redemption_api.framework.tools.GogoTools;
import cc.redemption_api.meta.admin.entity.Admin;
import cc.redemption_api.meta.admin.entity.AdminView;
import cc.redemption_api.middle.IAdminMiddle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AdminUserBService implements IAdminUserBService {
    private final IAdminMiddle iAdminMiddle;

    public AdminUserBService(IAdminMiddle iAdminMiddle) {
        this.iAdminMiddle = iAdminMiddle;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void createRootAdmin(Map in) throws Exception {
        String loginName = in.get("loginName").toString();
        String password = in.get("password").toString();
        String roleType = in.get("roleType").toString();

        Map qIn = new HashMap();
        qIn.put("loginName", loginName);
        AdminView adminView = iAdminMiddle.getAdmin(qIn, true);
        if (adminView != null) {
            //该账号已经存在了
            throw new Exception("10003");
        }

        Admin admin = new Admin();
        admin.setAdminId(GogoTools.UUID32());
        admin.setCreateTime(new Date());
        admin.setLoginName(loginName);
        admin.setLoginPassword(GogoTools.encoderByMd5(password));
        admin.setRoleType(roleType);
        admin.setToken(GogoTools.UUID32());
        admin.setTokenTime(new Date());
        iAdminMiddle.createAdmin(admin);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Map adminLogin(Map in) throws Exception {
        String loginName = in.get("loginName").toString();
        String password = in.get("password").toString();

        Map qIn = new HashMap();
        qIn.put("loginName", loginName);
        AdminView adminView = iAdminMiddle.getAdmin(qIn, false);

        if (!adminView.getLoginPassword().equals(GogoTools.encoderByMd5(password))) {
            //login name or password error
            throw new Exception("10004");
        }

        qIn = new HashMap();
        String token = GogoTools.UUID32();

        qIn.put("token", token);
        qIn.put("tokenTime", new Date());
        qIn.put("adminId", adminView.getAdminId());
        iAdminMiddle.updateAdmin(qIn);

        Map out = new HashMap();
        out.put("token", token);

        return out;
    }

    @Override
    public Map adminLoginByToken(Map in) throws Exception {
        String token = in.get("token").toString();

        Map qIn = new HashMap();
        qIn.put("token", token);
        AdminView adminView = iAdminMiddle.getAdmin(qIn, false);

        Map out = new HashMap();
        out.put("token", adminView.getToken());

        return out;
    }
}
