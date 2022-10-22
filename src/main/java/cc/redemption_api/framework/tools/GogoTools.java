package cc.redemption_api.framework.tools;

import org.apache.tomcat.util.codec.binary.Base64;

import java.security.MessageDigest;
import java.util.Date;
import java.util.UUID;

public class GogoTools {
    /**
     * 生成一个UUID
     *
     * @return
     * @throws Exception
     */
    public static String UUID32() throws Exception {
        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString().replaceAll("-", "");
        return uuidStr;
    }

    // 两个日期相减得到的毫秒数
    public static long dateDiff(Date beginDate, Date endDate) {
        long date1ms = beginDate.getTime();
        long date2ms = endDate.getTime();
        return date2ms - date1ms;
    }

    /**
     * 对用户密码进行MD5加密
     *
     * @param password
     * @return
     * @throws Exception
     */
    public static String encoderByMd5(String password) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] newpass = Base64.encodeBase64(md5.digest(password.getBytes("utf-8")));
        String str = new String(newpass);
        return str;
    }
}
