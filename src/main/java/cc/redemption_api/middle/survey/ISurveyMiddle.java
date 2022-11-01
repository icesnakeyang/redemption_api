package cc.redemption_api.middle.survey;

import cc.redemption_api.meta.survey.entity.SurveyAnswer;
import cc.redemption_api.meta.survey.entity.SurveyLib;
import cc.redemption_api.meta.survey.entity.SurveyView;

import java.util.ArrayList;
import java.util.Map;

public interface ISurveyMiddle {
    /**
     * 创建一个survey问题库
     *
     * @param surveyLib
     */
    void createSurveyLib(SurveyLib surveyLib) throws Exception;

    /**
     * 读取问题库列表
     *
     * @param qIn keyTitle
     *            offset
     *            size
     * @return
     */
    ArrayList<SurveyView> listSurveyLib(Map qIn) throws Exception;

    Integer totalSurveyLib(Map qIn) throws Exception;

    /**
     * 读取一条问题详情
     *
     * @param questionId
     * @return
     */
    SurveyView getSurveyLib(String questionId) throws Exception;

    /**
     * 修改问题库问题
     *
     * @param qIn qTitle
     *            qContent
     *            answerType
     *            questionId
     */
    void updateSurveyLib(Map qIn) throws Exception;

    /**
     * 物理删除问题库里的问题
     *
     * @param questionId
     */
    void deleteSurveyLib(String questionId) throws Exception;

    /**
     * 创建用户回答记录
     *
     * @param surveyAnswer
     */
    void createSurveyAnswer(SurveyAnswer surveyAnswer) throws Exception;

    /**
     * 查询用户回答记录列表
     *
     * @param qIn userId
     *            answerType
     *            answer
     *            questionId
     * @return
     */
    ArrayList<SurveyView> listSurveyAnswer(Map qIn) throws Exception;

    Integer totalSurveyAnswer(Map qIn) throws Exception;

    /**
     * 统计所有是非选择题的答案汇总
     */
    ArrayList<Map> statisticSurveyAnswer1() throws Exception;
}
