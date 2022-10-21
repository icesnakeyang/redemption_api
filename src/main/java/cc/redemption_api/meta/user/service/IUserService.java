package cc.redemption_api.meta.user.service;

import cc.redemption_api.meta.user.dao.UserBaseDao;
import cc.redemption_api.meta.user.entity.UserBase;
import cc.redemption_api.meta.user.entity.UserView;

import java.util.Map;

public interface IUserService {
    void createUserBase(UserBase userBase) throws Exception;

    /**
     * @param qIn phone
     * @return
     */
    UserView getUserBase(Map qIn) throws Exception;
}
