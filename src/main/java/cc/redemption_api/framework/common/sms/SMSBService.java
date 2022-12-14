package cc.redemption_api.framework.common.sms;

import cc.redemption_api.framework.tools.GogoTools;
import cc.redemption_api.meta.setting.entity.Setting;
import cc.redemption_api.meta.sms.ISMSService;
import cc.redemption_api.meta.sms.SMSLog;
import cc.redemption_api.middle.settings.ISettingMiddle;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Slf4j
@Service
public class SMSBService implements ISMSBService {
    private final ISMSService ismsService;
    private final RestTemplate restTemplate;
    private final ISettingMiddle iSettingMiddle;

    public SMSBService(ISMSService ismsService, RestTemplate restTemplate,
                       ISettingMiddle iSettingMiddle) {
        this.ismsService = ismsService;
        this.restTemplate = restTemplate;
        this.iSettingMiddle = iSettingMiddle;
    }

    @Override
    public void getPhoneVerifyCode(Map in) throws Exception {
        String phone = (String) in.get("phone");
        if (phone == null) {
            throw new Exception("10069");
        }
        phone = "6" + phone;
        /**
         * 读取数据库，看当前是否有有效的验证码，如果有，且离上次发送不到1分钟，则暂停发送
         */
        Map qIn = new HashMap();
        qIn.put("phone", phone);
        SMSLog smsLog = ismsService.getSMSLog(phone);
        if (smsLog != null) {
            Long seconds = GogoTools.dateDiff(smsLog.getCreateTime(), new Date());
            seconds = seconds / 1000;
            if (seconds < 60) {
                //一分钟内不能重复发送验证码
                throw new Exception("10085");
            } else {
                /**
                 * 删除原来的验证码
                 */
                ismsService.deleteSMSLog(phone);
            }
        }

        /**
         * 生成验证码
         */
//        String codeStr = String.valueOf(new Random().nextInt(899999) + 100000);
        String codeStr = String.valueOf(new Random().nextInt(8999) + 1000);
        /**
         * 发送短信
         */

        sendSMS(phone, codeStr);

        /**
         * 把验证码保存到数据库
         */
        smsLog = new SMSLog();
        smsLog.setCode(codeStr);
        smsLog.setCreateTime(new Date());
        smsLog.setPhone(phone);
        ismsService.createSMSLog(smsLog);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void verifySMSCode(Map in) throws Exception {
        String phone = in.get("phone").toString();
        String code = in.get("code").toString();

        phone = "6" + phone;
        SMSLog smsLog = ismsService.getSMSLog(phone);
        if (smsLog == null) {
            throw new Exception("10074");
        }
        if (!smsLog.getCode().equals(code)) {
            throw new Exception("10072");
        }

        /**
         * 计算当前时间是否已经超过5分钟
         */
        Date now = new Date();
        long currentTime = now.getTime();
        long theTime = smsLog.getCreateTime().getTime();

        long diff = (currentTime - theTime) / 1000 / 60;

        if (diff > 5) {
            //超过5分钟了
            throw new Exception("10071");
        }

        /**
         * 验证成功，删除验收短信
         */
        ismsService.deleteSMSLog(phone);
    }

    void sendSMS(String phone, String codeStr) throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("message", codeStr);

        Map qIn = new HashMap();
        qIn.put("paramName", "ani");
        Setting setting = iSettingMiddle.getSetting(qIn, false);
        String ani = setting.getParamValue();

//        String url = "https://sms1.commpeak.com:8002/api?username=useruser20&password=43420024420&ani=" + ani + "&dnis=" + phone + "&message=RM0 Verification code = " + codeStr + "&command=submit&longMessageMode=split";
        String url = "https://www.onesms.my/api/send.php?apiKey=29a6bcc35adb8150f990734436df718d&recipients=" + phone + "&messageContent=code=" + codeStr + "&referenceID=5678";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
//        ResponseEntity<String> resEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
        String restultMapStr = restTemplate.getForObject(url, String.class);
        JSONObject object = JSON.parseObject(restultMapStr);
        String msgCode = (String) object.get("msgCode");
        if (msgCode != null && msgCode.equals("E00001")) {
            log.info("send sms success:" + phone + "/" + codeStr);
        } else {
            //send sms error
            log.error("send sms error:" + url);
            throw new Exception("10005");
        }
    }

    void sendSMS2(String phone, String codeStr) throws Exception {
//        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "0O9R0XlXcfYcPUwB", "Vhx4wv8LUrpkQkeLQ0BYKMPg9KV950");
//        IAcsClient client = new DefaultAcsClient(profile);
//
//        CommonRequest request = new CommonRequest();
//        request.setMethod(MethodType.POST);
//        request.setDomain("dysmsapi.aliyuncs.com");
//        request.setVersion("2017-05-25");
//        request.setAction("SendSms");
//        request.putQueryParameter("RegionId", "cn-hangzhou");
//        request.putQueryParameter("PhoneNumbers", phone);
//        request.putQueryParameter("SignName", "举手帮");
//        request.putQueryParameter("TemplateCode", "SMS_215071259");
//        request.putQueryParameter("TemplateParam", "{\"code\":\"" + codeStr + "\"}");
//        CommonResponse response = client.getCommonResponse(request);
//        JSONObject jsonObject=new JSONObject(response.getData());
//        if(jsonObject!=null){
//            String code=jsonObject.get("Code").toString();
//            if(!code.equals("OK")){
//                throw new Exception("10070");
//            }
//        }
    }
}
