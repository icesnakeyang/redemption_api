package cc.redemption_api.business.user;

import cc.redemption_api.middle.IUserMiddle;
import org.springframework.stereotype.Service;

@Service
public class UserBService implements IUserBService{
    private final IUserMiddle iUserMiddle;

    public UserBService(IUserMiddle iUserMiddle) {
        this.iUserMiddle = iUserMiddle;
    }
}
