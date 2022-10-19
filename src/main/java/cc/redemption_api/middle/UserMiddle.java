package cc.redemption_api.middle;

import cc.redemption_api.meta.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMiddle implements IUserMiddle{
    private final IUserService iUserService;

    public UserMiddle(IUserService iUserService) {
        this.iUserService = iUserService;
    }
}
