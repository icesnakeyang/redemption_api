package cc.redemption_api.meta.user.entity;

import lombok.Data;

@Data
public class UserView {
    private Integer ids;
    private String userId;
    private String phone;
    private String name;
    private String address;
    private String postCode;
    private String email;
    private String ICNumber;
}
