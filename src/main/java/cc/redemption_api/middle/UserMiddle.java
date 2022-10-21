package cc.redemption_api.middle;

import cc.redemption_api.meta.user.entity.UserBase;
import cc.redemption_api.meta.user.entity.UserView;
import cc.redemption_api.meta.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserMiddle implements IUserMiddle {
    private final IUserService iUserService;

    public UserMiddle(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @Override
    public void createUserBase(UserBase userBase) throws Exception {
        iUserService.createUserBase(userBase);
    }

    @Override
    public UserView getUserBase(Map qIn) throws Exception {
        UserView userView = iUserService.getUserBase(qIn);
        return userView;
    }
}
