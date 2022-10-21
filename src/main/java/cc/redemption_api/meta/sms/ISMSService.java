package cc.redemption_api.meta.sms;

public interface ISMSService {
    void createSMSLog(SMSLog smsLog) throws Exception;

    SMSLog getSMSLog(String phone) throws Exception;

    void deleteSMSLog(String phone) throws Exception;
}
