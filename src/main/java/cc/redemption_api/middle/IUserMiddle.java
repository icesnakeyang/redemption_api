package cc.redemption_api.middle;

import cc.redemption_api.meta.user.entity.UserBase;
import cc.redemption_api.meta.user.entity.UserView;

import java.util.ArrayList;
import java.util.Map;

public interface IUserMiddle {
    void createUserBase(UserBase userBase) throws Exception;

    /**
     * @param in phone
     * @return
     */
    UserView getUserBase(Map in) throws Exception;

    ArrayList<UserView> listUserBase(Map qIn) throws Exception;

    Integer totalUserBase(Map qIn) throws Exception;
}
