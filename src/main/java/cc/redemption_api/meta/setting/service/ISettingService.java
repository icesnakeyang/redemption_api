package cc.redemption_api.meta.setting.service;

import cc.redemption_api.meta.setting.entity.Setting;

import java.util.ArrayList;
import java.util.Map;

public interface ISettingService {
    void createSetting(Setting setting) throws Exception;

    ArrayList<Setting> listSetting(Map qIn) throws Exception;

    Setting getSetting(Map qIn) throws Exception;

    void updateSetting(Map qIn) throws Exception;

    void deleteSetting(String settingId) throws Exception;
}
