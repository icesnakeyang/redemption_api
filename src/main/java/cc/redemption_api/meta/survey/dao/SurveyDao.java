package cc.redemption_api.meta.survey.dao;

import cc.redemption_api.meta.survey.entity.SurveyAnswer;
import cc.redemption_api.meta.survey.entity.SurveyLib;
import cc.redemption_api.meta.survey.entity.SurveyView;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.Map;

@Mapper
public interface SurveyDao {
    /**
     * 创建一个survey问题库
     *
     * @param surveyLib
     */
    void createSurveyLib(SurveyLib surveyLib);

    /**
     * 读取问题库列表
     *
     * @param qIn keyTitle
     *            offset
     *            size
     * @return
     */
    ArrayList<SurveyView> listSurveyLib(Map qIn);

    Integer totalSurveyLib(Map qIn);

    /**
     * 读取一条问题详情
     *
     * @param questionId
     * @return
     */
    SurveyView getSurveyLib(String questionId);

    /**
     * 修改问题库问题
     *
     * @param qIn qTitle
     *            qContent
     *            answerType
     *            questionId
     */
    void updateSurveyLib(Map qIn);

    /**
     * 物理删除问题库里的问题
     *
     * @param questionId
     */
    void deleteSurveyLib(String questionId);

    /**
     * 创建用户回答记录
     *
     * @param surveyAnswer
     */
    void createSurveyAnswer(SurveyAnswer surveyAnswer);

    /**
     * 查询用户回答记录列表
     *
     * @param qIn userId
     *            answerType
     *            answer
     *            questionId
     * @return
     */
    ArrayList<SurveyView> listSurveyAnswer(Map qIn);

    Integer totalSurveyAnswer(Map qIn);


    /**
     * 统计所有是非选择题的答案汇总
     */
    ArrayList<Map> statisticSurveyAnswer1();
}
