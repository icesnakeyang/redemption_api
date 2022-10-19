package cc.redemption_api.business.form1;

import cc.redemption_api.framework.tools.GogoTools;
import cc.redemption_api.meta.user.entity.UserBase;
import cc.redemption_api.middle.IUserMiddle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class Form1BService implements IForm1BService {
    private final IUserMiddle iUserMiddle;

    public Form1BService(IUserMiddle iUserMiddle) {
        this.iUserMiddle = iUserMiddle;
    }

    @Override
    public void saveForm1(Map in) throws Exception {
        String name = in.get("name").toString();
        String icNumber1 = in.get("icNumber1").toString();
        String icNumber2 = in.get("icNumber2").toString();
        String icNumber3 = in.get("icNumber3").toString();
        String phoneF1 = in.get("phoneF1").toString();
        String phoneF2 = in.get("phoneF2").toString();
        String address = in.get("address").toString();
        String postcode = in.get("postcode").toString();
        String email = in.get("email").toString();

        UserBase userBase = new UserBase();
        userBase.setUserId(GogoTools.UUID32());
        userBase.setAddress(address);
        userBase.setEmail(email);
        String ic = icNumber1 + icNumber2 + icNumber3;
        userBase.setICNumber(ic);
        userBase.setIc1(icNumber1);
        userBase.setIc2(icNumber2);
        userBase.setIc3(icNumber3);
        userBase.setName(name);
        userBase.setEmail(email);
        userBase.setPostCode(postcode);
        userBase.setPhone(phoneF1 + phoneF2);
        userBase.setPhone1(phoneF1);
        userBase.setPhone2(phoneF2);
    }
}
