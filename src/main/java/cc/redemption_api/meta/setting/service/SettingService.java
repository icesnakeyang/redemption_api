package cc.redemption_api.meta.setting.service;

import cc.redemption_api.meta.setting.dao.SettingDao;
import cc.redemption_api.meta.setting.entity.Setting;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class SettingService implements ISettingService {
    private final SettingDao settingDao;

    public SettingService(SettingDao settingDao) {
        this.settingDao = settingDao;
    }

    @Override
    public void createSetting(Setting setting) throws Exception {
        settingDao.createSetting(setting);
    }

    @Override
    public ArrayList<Setting> listSetting(Map qIn) throws Exception {
        ArrayList<Setting> setting = settingDao.listSetting(qIn);
        return setting;
    }

    @Override
    public Setting getSetting(Map qIn) throws Exception {
        Setting setting = settingDao.getSetting(qIn);
        return setting;
    }

    @Override
    public void updateSetting(Map qIn) throws Exception {
        settingDao.updateSetting(qIn);
    }

    @Override
    public void deleteSetting(String settingId) throws Exception {
        settingDao.deleteSetting(settingId);
    }
}
