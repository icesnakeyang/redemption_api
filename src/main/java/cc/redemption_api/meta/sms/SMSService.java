package cc.redemption_api.meta.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SMSService implements ISMSService {
    private final SMSLogDao smsLogDao;

    public SMSService(SMSLogDao smsLogDao) {
        this.smsLogDao = smsLogDao;
    }

    @Override
    public void createSMSLog(SMSLog smsLog) throws Exception {
        smsLogDao.createSMSLog(smsLog);
    }

    @Override
    public SMSLog getSMSLog(String phone) throws Exception {
        SMSLog smsLog = smsLogDao.getSMSLog(phone);
        return smsLog;
    }

    @Override
    public void deleteSMSLog(String phone) throws Exception {
        smsLogDao.deleteSMSLog(phone);
    }
}
