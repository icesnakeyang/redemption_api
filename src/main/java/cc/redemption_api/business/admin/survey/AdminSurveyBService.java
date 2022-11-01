package cc.redemption_api.business.admin.survey;

import cc.redemption_api.framework.tools.GogoTools;
import cc.redemption_api.meta.admin.entity.AdminView;
import cc.redemption_api.meta.survey.entity.SurveyAnswer;
import cc.redemption_api.meta.survey.entity.SurveyLib;
import cc.redemption_api.meta.survey.entity.SurveyView;
import cc.redemption_api.middle.IAdminMiddle;
import cc.redemption_api.middle.survey.ISurveyMiddle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AdminSurveyBService implements IAdminSurveyBService {
    private final IAdminMiddle iAdminMiddle;
    private final ISurveyMiddle iSurveyMiddle;

    public AdminSurveyBService(IAdminMiddle iAdminMiddle,
                               ISurveyMiddle iSurveyMiddle) {
        this.iAdminMiddle = iAdminMiddle;
        this.iSurveyMiddle = iSurveyMiddle;
    }

    @Override
    public Map listSurvey(Map in) throws Exception {
        String token = in.get("token").toString();
        Integer pageIndex = (Integer) in.get("pageIndex");
        Integer pageSize = (Integer) in.get("pageSize");

        Map qIn = new HashMap();
        qIn.put("token", token);
        AdminView adminView = iAdminMiddle.getAdmin(qIn, false);

        Integer offset = (pageIndex - 1) * pageSize;
        qIn = new HashMap();
        qIn.put("offset", offset);
        qIn.put("size", pageSize);

        ArrayList<SurveyView> surveyViews = iSurveyMiddle.listSurveyLib(qIn);

        Map out = new HashMap();
        out.put("surveyList", surveyViews);

        return out;
    }

    @Override
    public void saveSurvey(Map in) throws Exception {
        String token = in.get("token").toString();
        String title = in.get("title").toString();
        String content = in.get("content").toString();

        Map qIn = new HashMap();
        qIn.put("token", token);
        AdminView adminView = iAdminMiddle.getAdmin(qIn, false);

        SurveyLib surveyLib = new SurveyLib();
        surveyLib.setCreateTime(new Date());
        surveyLib.setAnswerType("BOOLEAN");
        surveyLib.setQTitle(title);
        surveyLib.setQContent(content);
        surveyLib.setQuestionId(GogoTools.UUID32());
        surveyLib.setStatus("ACTIVE");
        iSurveyMiddle.createSurveyLib(surveyLib);
    }

    @Override
    public Map statisticSurvey1(Map in) throws Exception {
        String token = in.get("token").toString();

        Map qIn = new HashMap();
        qIn.put("token", token);
        AdminView adminView = iAdminMiddle.getAdmin(qIn, false);

        ArrayList<Map> surveyViews = iSurveyMiddle.statisticSurveyAnswer1();

        Map out = new HashMap();
        out.put("statisticSurvey1", surveyViews);
        return out;
    }
}
