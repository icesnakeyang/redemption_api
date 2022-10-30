package cc.redemption_api.meta.survey.entity;

import lombok.Data;

import java.util.Date;

/**
 * 问题库
 */
@Data
public class SurveyLib {
    private Integer ids;
    private String questionId;
    private String qTitle;
    private String qContent;
    private String answerType;
    private Date createTime;
    private String status;
}
