package cc.redemption_api.business.admin;

import cc.redemption_api.framework.constant.ESTags;
import cc.redemption_api.framework.tools.GogoTools;
import cc.redemption_api.meta.admin.entity.Admin;
import cc.redemption_api.meta.admin.entity.AdminView;
import cc.redemption_api.middle.IAdminMiddle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AdminBService implements IAdminBService {
    private final IAdminMiddle iAdminMiddle;

    public AdminBService(IAdminMiddle iAdminMiddle) {
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

    @Override
    public Map listAdminUser(Map in) throws Exception {
        String token = in.get("token").toString();
        Integer pageIndex = (Integer) in.get("pageIndex");
        Integer pageSize = (Integer) in.get("pageSize");

        Map qIn = new HashMap();
        qIn.put("token", token);
        AdminView adminView = iAdminMiddle.getAdmin(qIn, false);

        qIn = new HashMap();
        Integer offset = (pageIndex - 1) * pageSize;
        qIn.put("offset", offset);
        qIn.put("size", pageSize);
        ArrayList<AdminView> adminViews = iAdminMiddle.listAdmin(qIn);

        Map out = new HashMap();
        out.put("adminList", adminViews);

        return out;
    }

    @Override
    public void createAdmin(Map in) throws Exception {
        String loginName = in.get("loginName").toString();
        String password = in.get("password").toString();
        String roleType = (String) in.get("roleType");
        String token = in.get("token").toString();

        Map qIn = new HashMap();
        qIn.put("token", token);
        AdminView adminView = iAdminMiddle.getAdmin(qIn, false);

        qIn = new HashMap();
        qIn.put("loginName", loginName);
        AdminView adminView2 = iAdminMiddle.getAdmin(qIn, true);
        if (adminView2 != null) {
            //该账号已经存在了
            throw new Exception("10003");
        }

        Admin admin = new Admin();
        admin.setAdminId(GogoTools.UUID32());
        admin.setCreateTime(new Date());
        admin.setLoginName(loginName);
        admin.setLoginPassword(GogoTools.encoderByMd5(password));
        if (roleType == null) {
            roleType = ESTags.ADMIN_NORMAL.toString();
        }
        admin.setRoleType(roleType);
        admin.setToken(GogoTools.UUID32());
        admin.setTokenTime(new Date());
        iAdminMiddle.createAdmin(admin);
    }
}
