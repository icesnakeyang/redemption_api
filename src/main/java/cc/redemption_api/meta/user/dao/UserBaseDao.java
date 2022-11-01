package cc.redemption_api.meta.user.dao;

import cc.redemption_api.meta.user.entity.UserBase;
import cc.redemption_api.meta.user.entity.UserView;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.Map;

@Mapper
public interface UserBaseDao {
    void createUserBase(UserBase userBase);

    /**
     * @param qIn phone
     *            icNumber
     *            userId
     * @return
     */
    UserView getUserBase(Map qIn);

    ArrayList<UserView> listUserBase(Map qIn);

    Integer totalUserBase(Map qIn);
}
