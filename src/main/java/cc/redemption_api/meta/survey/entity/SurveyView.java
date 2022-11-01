package cc.redemption_api.meta.survey.entity;

import lombok.Data;

import java.util.Date;

@Data
public class SurveyView {
    private Integer ids;
    private String questionId;
    private String userId;
    private Date createTime;
    private String answer;
    private String qTitle;
    private String qContent;
    private String answerType;
    private String status;
    private Integer total;
}
