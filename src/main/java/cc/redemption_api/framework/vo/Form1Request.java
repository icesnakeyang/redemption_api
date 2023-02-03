package cc.redemption_api.framework.vo;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Form1Request {
    private String userName;
    private String icNumber;
    private String icNumber1;
    private String icNumber2;
    private String icNumber3;
    private String phoneF1;
    private String phoneF2;
    private String address;
    private String postcode;
    private String email;
    private ArrayList surveys;
    private String phone;
}
