package cc.redemption_api.middle.settings;

import cc.redemption_api.meta.setting.entity.Setting;

import java.util.ArrayList;
import java.util.Map;

public interface ISettingMiddle {
    void createSetting(Setting settings) throws Exception;

    ArrayList<Setting> listSetting(Map qIn) throws Exception;

    Setting getSetting(Map qIn, Boolean returnNull) throws Exception;

    void updateSetting(Map qIn) throws Exception;

    void deleteSetting(String settingId) throws Exception;
}
