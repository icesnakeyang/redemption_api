package cc.redemption_api.meta.sms;

import lombok.Data;

import java.util.Date;

/**
 * 短信日志表
 */
@Data
public class SMSLog {
    private Integer ids;
    private String phone;
    private String code;
    private Date createTime;
}
