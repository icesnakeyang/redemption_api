package cc.redemption_api.framework.vo;

import lombok.Data;

@Data
public class AdminRequest {
    private String loginName;
    private String password;
    private String roleType;
}
