package cc.redemption_api.meta.sms;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SMSLogDao {
    void createSMSLog(SMSLog smsLog);

    SMSLog getSMSLog(String phone);

    void deleteSMSLog(String phone);
}
