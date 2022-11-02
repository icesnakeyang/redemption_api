package cc.redemption_api.business.admin.user;

import cc.redemption_api.meta.admin.entity.AdminView;
import cc.redemption_api.meta.survey.entity.SurveyView;
import cc.redemption_api.meta.user.entity.UserView;
import cc.redemption_api.middle.IAdminMiddle;
import cc.redemption_api.middle.IUserMiddle;
import cc.redemption_api.middle.survey.ISurveyMiddle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class AdminUserBService implements IAdminUserBService {
    private final IAdminMiddle iAdminMiddle;
    private final IUserMiddle iUserMiddle;
    private final ISurveyMiddle iSurveyMiddle;

    public AdminUserBService(IAdminMiddle iAdminMiddle,
                             IUserMiddle iUserMiddle,
                             ISurveyMiddle iSurveyMiddle) {
        this.iAdminMiddle = iAdminMiddle;
        this.iUserMiddle = iUserMiddle;
        this.iSurveyMiddle = iSurveyMiddle;
    }

    @Override
    public Map listUser(Map in) throws Exception {
        String token = in.get("token").toString();
        Integer pageIndex = (Integer) in.get("pageIndex");
        Integer pageSize = (Integer) in.get("pageSize");

        Map qIn = new HashMap();
        qIn.put("token", token);
        AdminView adminView = iAdminMiddle.getAdmin(qIn, false);

        qIn = new HashMap();
        if (pageIndex != null) {
            Integer offset = (pageIndex - 1) * pageSize;
            qIn.put("offset", offset);
            qIn.put("size", pageSize);
        }
        ArrayList<UserView> userViews = iUserMiddle.listUserBase(qIn);
        Integer total = iUserMiddle.totalUserBase(qIn);

        Map out = new HashMap();
        out.put("userList", userViews);
        out.put("totalUser", total);

        return out;
    }

    @Override
    public Map getUserDetail(Map in) throws Exception {
        String token = in.get("token").toString();
        String userId = in.get("userId").toString();

        Map qIn = new HashMap();
        qIn.put("token", token);
        AdminView adminView = iAdminMiddle.getAdmin(qIn, false);

        qIn = new HashMap();
        qIn.put("userId", userId);
        UserView userView = iUserMiddle.getUserBase(qIn, false);

        Map out = new HashMap();
        out.put("user", userView);

        ArrayList<SurveyView> surveyViews = iSurveyMiddle.listSurveyAnswer(qIn);
        out.put("surveyList", surveyViews);

        return out;
    }

    @Override
    public Map loadUserStatistic(Map in) throws Exception {
        String token = in.get("token").toString();

        Map qIn = new HashMap();
        qIn.put("token", token);
        AdminView adminView = iAdminMiddle.getAdmin(qIn, false);

        Integer totalUserBase = iUserMiddle.totalUserBase(qIn);

        Map out = new HashMap();
        out.put("totalUserBase", totalUserBase);

        return out;
    }
}
