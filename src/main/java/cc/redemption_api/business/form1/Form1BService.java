package cc.redemption_api.business.form1;

import cc.redemption_api.framework.tools.GogoTools;
import cc.redemption_api.meta.survey.entity.SurveyAnswer;
import cc.redemption_api.meta.survey.entity.SurveyView;
import cc.redemption_api.meta.user.entity.UserBase;
import cc.redemption_api.meta.user.entity.UserView;
import cc.redemption_api.middle.IUserMiddle;
import cc.redemption_api.middle.survey.ISurveyMiddle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class Form1BService implements IForm1BService {
    private final IUserMiddle iUserMiddle;
    private final ISurveyMiddle iSurveyMiddle;

    public Form1BService(IUserMiddle iUserMiddle,
                         ISurveyMiddle iSurveyMiddle) {
        this.iUserMiddle = iUserMiddle;
        this.iSurveyMiddle = iSurveyMiddle;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveForm1(Map in) throws Exception {
        String userName = in.get("userName").toString();
        String icNumber1 = in.get("icNumber1").toString();
        String icNumber2 = in.get("icNumber2").toString();
        String icNumber3 = in.get("icNumber3").toString();
        String phoneF1 = in.get("phoneF1").toString();
        String phoneF2 = in.get("phoneF2").toString();
        String address = in.get("address").toString();
        String postcode = in.get("postcode").toString();
        String email = in.get("email").toString();
        ArrayList surveys = (ArrayList) in.get("surveys");

        Map qIn = new HashMap();
        qIn.put("icNumber", icNumber1 + icNumber2 + icNumber3);
        UserView userView = iUserMiddle.getUserBase(qIn, true);

        if (userView == null) {
            UserBase userBase = new UserBase();
            userBase.setUserId(GogoTools.UUID32());
            userBase.setAddress(address);
            userBase.setEmail(email);
            String ic = icNumber1 + icNumber2 + icNumber3;
            userBase.setICNumber(ic);
            userBase.setIc1(icNumber1);
            userBase.setIc2(icNumber2);
            userBase.setIc3(icNumber3);
            userBase.setUserName(userName);
            userBase.setEmail(email);
            userBase.setPostcode(postcode);
            userBase.setPhone(phoneF1 + phoneF2);
            userBase.setPhone1(phoneF1);
            userBase.setPhone2(phoneF2);
            userBase.setCreateTime(new Date());
            iUserMiddle.createUserBase(userBase);

            for (int i = 0; i < surveys.size(); i++) {
                Map s = (Map) surveys.get(i);
                SurveyAnswer surveyAnswer = new SurveyAnswer();
                String questionId = (String) s.get("questionId");
                try {
                    String answer = (String) s.get("answer");
                    surveyAnswer.setAnswer(answer);
                } catch (Exception e) {
                    Boolean answer = (Boolean) s.get("answer");
                    surveyAnswer.setAnswer(answer.toString());
                }
                if (questionId != null) {
                    surveyAnswer.setQuestionId(questionId);
                    surveyAnswer.setCreateTime(new Date());
                    surveyAnswer.setUserId(userBase.getUserId());
                    iSurveyMiddle.createSurveyAnswer(surveyAnswer);
                }
            }
        } else {
            /**
             * 当前用户已经填过调查表了
             */
            throw new Exception("10007");
        }
    }

    @Override
    public Map listSurveyLib(Map in) throws Exception {
        Map qIn = new HashMap();
        ArrayList<SurveyView> surveyViews = iSurveyMiddle.listSurveyLib(qIn);

        Map out = new HashMap();
        out.put("surveyList", surveyViews);

        return out;
    }
}
