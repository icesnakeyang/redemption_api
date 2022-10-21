package cc.redemption_api.framework.common.sms;

import java.util.Map;

public interface ISMSBService {
    void getPhoneVerifyCode(Map in) throws Exception;

    void verifySMSCode(Map in) throws Exception;
}
