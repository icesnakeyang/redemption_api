package cc.redemption_api.business.admin.survey;

import java.util.Map;

public interface IAdminSurveyBService {
    Map listSurvey(Map in) throws Exception;

    void saveSurvey(Map in) throws Exception;

    Map statisticSurvey1(Map in) throws Exception;
}
