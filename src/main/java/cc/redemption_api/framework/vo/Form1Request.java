package cc.redemption_api.framework.vo;

import lombok.Data;

@Data
public class Form1Request {
    private String name;
    private String icNumber1;
    private String icNumber2;
    private String icNumber3;
    private String phoneF1;
    private String phoneF2;
    private String address;
    private String postcode;
    private String email;
}
