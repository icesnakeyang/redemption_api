package cc.redemption_api.middle;

import cc.redemption_api.meta.user.entity.UserBase;
import cc.redemption_api.meta.user.entity.UserView;
import cc.redemption_api.meta.user.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public UserView getUserBase(Map qIn, Boolean returnNull) throws Exception {
        UserView userView = iUserService.getUserBase(qIn);
        if(userView==null){
            if(returnNull){
                return null;
            }
            throw new Exception("10006");
        }
        return userView;
    }

    @Override
    public ArrayList<UserView> listUserBase(Map qIn) throws Exception {
        ArrayList<UserView> userViews = iUserService.listUserBase(qIn);
        return userViews;
    }

    @Override
    public Integer totalUserBase(Map qIn) throws Exception {
        Integer total = iUserService.totalUserBase(qIn);
        return total;
    }
}
