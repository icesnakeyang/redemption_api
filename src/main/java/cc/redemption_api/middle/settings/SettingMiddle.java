package cc.redemption_api.middle.settings;

import cc.redemption_api.meta.setting.entity.Setting;
import cc.redemption_api.meta.setting.service.ISettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class SettingMiddle implements ISettingMiddle {
    private final ISettingService iSettingService;

    public SettingMiddle(ISettingService iSettingService) {
        this.iSettingService = iSettingService;
    }

    @Override
    public void createSetting(Setting setting) throws Exception {
        iSettingService.createSetting(setting);
    }

    @Override
    public ArrayList<Setting> listSetting(Map qIn) throws Exception {
        ArrayList<Setting> settings = iSettingService.listSetting(qIn);
        return settings;
    }

    @Override
    public Setting getSetting(Map qIn, Boolean returnNull) throws Exception {
        Setting setting = iSettingService.getSetting(qIn);
        if (setting == null) {
            if (returnNull) {
                return null;
            }
            //didn't find this parameter
            throw new Exception("10009");
        }
        return setting;
    }

    @Override
    public void updateSetting(Map qIn) throws Exception {
        iSettingService.updateSetting(qIn);
    }

    @Override
    public void deleteSetting(String settingId) throws Exception {
        iSettingService.deleteSetting(settingId);
    }
}
