package cc.redemption_api.business.admin.user;

import java.util.Map;

public interface IAdminUserBService {
    Map listUser(Map in) throws Exception;

    Map getUserDetail(Map in) throws Exception;

    Map loadUserStatistic(Map in) throws Exception;
}
