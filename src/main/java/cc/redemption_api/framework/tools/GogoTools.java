package cc.redemption_api.framework.tools;

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
}
