package cc.redemption_api.business.admin.maintenance;

import cc.redemption_api.meta.admin.entity.AdminView;
import cc.redemption_api.middle.IAdminMiddle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class AdminMaintenanceBService implements IAdminMaintenanceBService {
    private final IAdminMiddle iAdminMiddle;

    public AdminMaintenanceBService(IAdminMiddle iAdminMiddle) {
        this.iAdminMiddle = iAdminMiddle;
    }

    @Override
    public Map loadExportData1(Map in) throws Exception {
        String token = in.get("token").toString();

        Map qIn = new HashMap();
        qIn.put("token", token);
        AdminView adminView = iAdminMiddle.getAdmin(qIn, false);

        ArrayList<Map> maps = iAdminMiddle.loadExportFile1(qIn);

        Map out = new HashMap();
        out.put("dataList", maps);
        return out;
    }
}
