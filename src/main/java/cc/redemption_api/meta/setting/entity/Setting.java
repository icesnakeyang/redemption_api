package cc.redemption_api.meta.setting.entity;

import lombok.Data;

import java.util.Date;

/**
 * 系统参数设置
 */
@Data
public class Setting {
    private Integer ids;
    private String paramName;
    private String paramValue;
    private String adminId;
    private Date createTime;
    private String settingId;
}
