package cc.redemption_api.framework.common.sms;

import cc.redemption_api.framework.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/redemption_api/sms")
public class SMSController {
    private final ISMSBService ismsbService;

    public SMSController(ISMSBService ismsbService) {
        this.ismsbService = ismsbService;
    }

    /**
     * 获取一个手机号码的验证码
     * @param request
     * @return
     */
    @ResponseBody
    @PostMapping("/getPhoneVerifyCode")
    public Response getPhoneVerifyCode(@RequestBody SMSRequest request) {
        Response response = new Response();
        Map in = new HashMap();
        try {
            in.put("phone", request.getPhone());
            ismsbService.getPhoneVerifyCode(in);
        } catch (Exception ex) {
            try {
                response.setCode(Integer.parseInt(ex.getMessage()));
            } catch (Exception ex2) {
                response.setCode(10001);
                log.error("getPhoneVerifyCode error:" + ex.getMessage());
            }
        }
        return response;
    }

    /**
     * 验证一个手机号码的验证码
     * @param request
     * @return
     */
    @ResponseBody
    @PostMapping("/verifySMSCode")
    public Response verifySMSCode(@RequestBody SMSRequest request) {
        Response response = new Response();
        Map in = new HashMap();
        try {
            in.put("phone", request.getPhone());
            in.put("code", request.getCode());
            ismsbService.verifySMSCode(in);
        } catch (Exception ex) {
            try {
                response.setCode(Integer.parseInt(ex.getMessage()));
            } catch (Exception ex2) {
                response.setCode(10001);
                log.error("verifySMSCode error:" + ex.getMessage());
            }
        }
        return response;
    }
}
