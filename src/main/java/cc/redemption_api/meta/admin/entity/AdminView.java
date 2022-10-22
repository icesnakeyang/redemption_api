package cc.redemption_api.meta.admin.entity;

import lombok.Data;

import java.util.Date;

@Data
public class AdminView {
    private Integer ids;
    private String adminId;
    private String loginName;
    private String loginPassword;
    private Date createTime;
    private String roleType;
    private String token;
    private Date tokenTime;
}
