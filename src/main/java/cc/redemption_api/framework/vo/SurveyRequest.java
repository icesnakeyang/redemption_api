package cc.redemption_api.framework.vo;

import lombok.Data;

@Data
public class SurveyRequest extends Request {
    private String title;
    private String content;
}
