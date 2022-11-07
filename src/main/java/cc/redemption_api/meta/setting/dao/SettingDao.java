package cc.redemption_api.meta.setting.dao;

import cc.redemption_api.meta.setting.entity.Setting;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.Map;

@Mapper
public interface SettingDao {
    void createSetting(Setting setting);

    ArrayList<Setting> listSetting(Map qIn);

    Setting getSetting(Map qIn);

    void updateSetting(Map qIn);

    void deleteSetting(String settingId);
}
