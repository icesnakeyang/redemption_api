package cc.redemption_api.meta.survey.service;

import cc.redemption_api.meta.survey.dao.SurveyDao;
import cc.redemption_api.meta.survey.entity.SurveyAnswer;
import cc.redemption_api.meta.survey.entity.SurveyLib;
import cc.redemption_api.meta.survey.entity.SurveyView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class SurveyService implements ISurveyService {
    private final SurveyDao surveyDao;

    public SurveyService(SurveyDao surveyDao) {
        this.surveyDao = surveyDao;
    }


    @Override
    public void createSurveyLib(SurveyLib surveyLib) throws Exception {
        surveyDao.createSurveyLib(surveyLib);
    }

    @Override
    public ArrayList<SurveyView> listSurveyLib(Map qIn) throws Exception {
        ArrayList<SurveyView> surveyViews = surveyDao.listSurveyLib(qIn);
        return surveyViews;
    }

    @Override
    public Integer totalSurveyLib(Map qIn) throws Exception {
        Integer total = surveyDao.totalSurveyLib(qIn);
        return total;
    }

    @Override
    public SurveyView getSurveyLib(String questionId) throws Exception {
        SurveyView surveyView = surveyDao.getSurveyLib(questionId);
        return surveyView;
    }

    @Override
    public void updateSurveyLib(Map qIn) throws Exception {
        surveyDao.updateSurveyLib(qIn);
    }

    @Override
    public void deleteSurveyLib(String questionId) throws Exception {
        surveyDao.deleteSurveyLib(questionId);
    }

    @Override
    public void createSurveyAnswer(SurveyAnswer surveyAnswer) throws Exception {
        surveyDao.createSurveyAnswer(surveyAnswer);
    }

    @Override
    public ArrayList<SurveyView> listSurveyAnswer(Map qIn) throws Exception {
        ArrayList<SurveyView> surveyViews = surveyDao.listSurveyAnswer(qIn);
        return surveyViews;
    }

    @Override
    public Integer totalSurveyAnswer(Map qIn) throws Exception {
        Integer total = surveyDao.totalSurveyAnswer(qIn);
        return total;
    }

    @Override
    public ArrayList<Map> statisticSurveyAnswer1() throws Exception {
        ArrayList<Map> surveyViews = surveyDao.statisticSurveyAnswer1();
        return surveyViews;
    }
}
