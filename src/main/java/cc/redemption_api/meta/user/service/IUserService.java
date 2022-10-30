package cc.redemption_api.meta.user.service;

import cc.redemption_api.meta.user.entity.UserBase;
import cc.redemption_api.meta.user.entity.UserView;

import java.util.ArrayList;
import java.util.Map;

public interface IUserService {
    void createUserBase(UserBase userBase) throws Exception;

    /**
     * @param qIn phone
     *            icNumber
     * @return
     */
    UserView getUserBase(Map qIn) throws Exception;

    ArrayList<UserView> listUserBase(Map qIn) throws Exception;

    Integer totalUserBase(Map qIn) throws Exception;
}
