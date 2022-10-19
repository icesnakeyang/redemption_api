package cc.redemption_api.meta.user.service;

import cc.redemption_api.meta.user.dao.UserBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    private final UserBaseDao userBaseDao;

    public UserService(UserBaseDao userBaseDao) {
        this.userBaseDao = userBaseDao;
    }
}
