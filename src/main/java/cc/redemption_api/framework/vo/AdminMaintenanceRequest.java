package cc.redemption_api.framework.vo;

import lombok.Data;

@Data
public class AdminMaintenanceRequest extends Request {
    private String paramName;
    private String paramValue;
    private String settingId;
}
