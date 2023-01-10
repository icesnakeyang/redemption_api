package cc.redemption_api.business.admin.maintenance;

import cc.redemption_api.framework.tools.GogoTools;
import cc.redemption_api.meta.admin.entity.AdminView;
import cc.redemption_api.meta.setting.entity.Setting;
import cc.redemption_api.middle.IAdminMiddle;
import cc.redemption_api.middle.settings.ISettingMiddle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AdminMaintenanceBService implements IAdminMaintenanceBService {
    private final IAdminMiddle iAdminMiddle;
    private final ISettingMiddle iSettingMiddle;

    public AdminMaintenanceBService(IAdminMiddle iAdminMiddle,
                                    ISettingMiddle iSettingMiddle) {
        this.iAdminMiddle = iAdminMiddle;
        this.iSettingMiddle = iSettingMiddle;
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

    @Override
    public Map listSetting(Map in) throws Exception {
        String token = in.get("token").toString();
        Integer pageIndex = (Integer) in.get("pageIndex");
        Integer pageSize = (Integer) in.get("pageSize");

        Map qIn = new HashMap();
        qIn.put("token", token);
        AdminView adminView = iAdminMiddle.getAdmin(qIn, false);

        qIn = new HashMap();
        Integer offset = (pageIndex - 1) * pageSize;
        qIn.put("offset", offset);
        qIn.put("size", pageSize);
        ArrayList<Setting> settings = iSettingMiddle.listSetting(qIn);

        Map out = new HashMap();
        out.put("settingList", settings);
        return out;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void createSetting(Map in) throws Exception {
        String token = in.get("token").toString();
        String paramName = in.get("paramName").toString();
        String paramValue = in.get("paramValue").toString();

        Map qIn = new HashMap();
        qIn.put("token", token);
        AdminView adminView = iAdminMiddle.getAdmin(qIn, false);

        qIn = new HashMap();
        qIn.put("paramName", paramName);
        Setting setting = iSettingMiddle.getSetting(qIn, true);

        if (setting != null) {
            //该参数已经存在
            throw new Exception("10008");
        }

        setting = new Setting();
        setting.setSettingId(GogoTools.UUID32());
        setting.setAdminId(adminView.getAdminId());
        setting.setCreateTime(new Date());
        setting.setParamName(paramName);
        setting.setParamValue(paramValue);
        iSettingMiddle.createSetting(setting);
    }

    @Override
    public void updateSetting(Map in) throws Exception {
        String token = in.get("token").toString();
        String paramName = in.get("paramName").toString();
        String paramValue = in.get("paramValue").toString();
        String settingId = in.get("settingId").toString();

        Map qIn = new HashMap();
        qIn.put("token", token);
        AdminView adminView = iAdminMiddle.getAdmin(qIn, false);

        qIn = new HashMap();
        qIn.put("settingId", settingId);
        Setting setting = iSettingMiddle.getSetting(qIn, false);

        qIn.put("paramName", paramName);
        qIn.put("paramValue", paramValue);
        iSettingMiddle.updateSetting(qIn);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteSetting(Map in) throws Exception {
        String token = in.get("token").toString();
        String settingId = in.get("settingId").toString();

        Map qIn = new HashMap();
        qIn.put("token", token);
        AdminView adminView = iAdminMiddle.getAdmin(qIn, false);

        iSettingMiddle.deleteSetting(settingId);
    }

    @Override
    public Map getSetting(Map in) throws Exception {
        String token = in.get("token").toString();
        String settingId = (String) in.get("settingId");
        String paramName = (String) in.get("paramName");

        Map qIn = new HashMap();
        qIn.put("token", token);
        AdminView adminView = iAdminMiddle.getAdmin(qIn, false);

        qIn = new HashMap();
        qIn.put("settingId", settingId);
        qIn.put("paramName", paramName);
        Setting setting = iSettingMiddle.getSetting(qIn, false);

        Map out = new HashMap();
        out.put("setting", setting);
        return out;
    }
}
