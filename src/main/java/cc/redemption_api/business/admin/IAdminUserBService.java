package cc.redemption_api.business.admin;

import java.util.Map;

public interface IAdminUserBService {
    void createRootAdmin(Map in) throws Exception;

    Map adminLogin(Map in) throws Exception;

    Map adminLoginByToken(Map in) throws Exception;
}
