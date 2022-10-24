package cc.redemption_api.meta.user.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserView {
    private Integer ids;
    private String userId;
    private String phone;
    private String name;
    private String address;
    private String postcode;
    private String email;
    private String ICNumber;
    private Date createTime;
    private String ic1;
    private String ic2;
    private String ic3;
    private String phone1;
    private String phone2;
}
