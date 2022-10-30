package cc.redemption_api.meta.survey.entity;

import lombok.Data;

import java.util.Date;

/**
 * 用户回答的问题
 */
@Data
public class SurveyAnswer {
    private Integer ids;
    private String questionId;
    private String userId;
    private Date createTime;
    private String answer;
}
