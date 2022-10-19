package cc.redemption_api.meta.user.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserBase {
    private Integer ids;
    private String userId;
    private String phone;
    private String name;
    private String address;
    private String postCode;
    private String email;
    private String ICNumber;
    private String ic1;
    private String ic2;
    private String ic3;
    private String phone1;
    private String phone2;
    private Date createTime;
}
