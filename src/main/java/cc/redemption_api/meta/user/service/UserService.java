package cc.redemption_api.meta.user.service;

import cc.redemption_api.meta.user.dao.UserBaseDao;
import cc.redemption_api.meta.user.entity.UserBase;
import cc.redemption_api.meta.user.entity.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService implements IUserService {
    private final UserBaseDao userBaseDao;

    public UserService(UserBaseDao userBaseDao) {
        this.userBaseDao = userBaseDao;
    }

    @Override
    public void createUserBase(UserBase userBase) throws Exception {
        userBaseDao.createUserBase(userBase);
    }

    @Override
    public UserView getUserBase(Map qIn) throws Exception {
        UserView userView = userBaseDao.getUserBase(qIn);
        return userView;
    }
}
