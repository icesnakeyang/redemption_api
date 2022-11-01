package cc.redemption_api.middle.survey;

import cc.redemption_api.meta.survey.entity.SurveyAnswer;
import cc.redemption_api.meta.survey.entity.SurveyLib;
import cc.redemption_api.meta.survey.entity.SurveyView;
import cc.redemption_api.meta.survey.service.ISurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class SurveyMiddle implements ISurveyMiddle {
    private final ISurveyService iSurveyService;

    public SurveyMiddle(ISurveyService iSurveyService) {
        this.iSurveyService = iSurveyService;
    }

    @Override
    public void createSurveyLib(SurveyLib surveyLib) throws Exception {
        iSurveyService.createSurveyLib(surveyLib);
    }

    @Override
    public ArrayList<SurveyView> listSurveyLib(Map qIn) throws Exception {
        ArrayList<SurveyView> surveyViews = iSurveyService.listSurveyLib(qIn);
        return surveyViews;
    }

    @Override
    public Integer totalSurveyLib(Map qIn) throws Exception {
        Integer total = iSurveyService.totalSurveyLib(qIn);
        return total;
    }

    @Override
    public SurveyView getSurveyLib(String questionId) throws Exception {
        SurveyView surveyView = iSurveyService.getSurveyLib(questionId);
        return surveyView;
    }

    @Override
    public void updateSurveyLib(Map qIn) throws Exception {
        iSurveyService.updateSurveyLib(qIn);
    }

    @Override
    public void deleteSurveyLib(String questionId) throws Exception {
        iSurveyService.deleteSurveyLib(questionId);
    }

    @Override
    public void createSurveyAnswer(SurveyAnswer surveyAnswer) throws Exception {
        iSurveyService.createSurveyAnswer(surveyAnswer);
    }

    @Override
    public ArrayList<SurveyView> listSurveyAnswer(Map qIn) throws Exception {
        ArrayList<SurveyView> surveyViews = iSurveyService.listSurveyAnswer(qIn);
        return surveyViews;
    }

    @Override
    public Integer totalSurveyAnswer(Map qIn) throws Exception {
        Integer total = iSurveyService.totalSurveyAnswer(qIn);
        return total;
    }

    @Override
    public ArrayList<Map> statisticSurveyAnswer1() throws Exception {
        ArrayList<Map> surveyViews = iSurveyService.statisticSurveyAnswer1();
        return surveyViews;
    }
}
