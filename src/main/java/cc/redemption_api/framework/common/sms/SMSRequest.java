package cc.redemption_api.framework.common.sms;

import lombok.Data;

@Data
public class SMSRequest {
    private String phone;
    private String code;
}
