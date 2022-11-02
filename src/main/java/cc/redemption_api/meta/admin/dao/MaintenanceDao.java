package cc.redemption_api.meta.admin.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.Map;

@Mapper
public interface MaintenanceDao {
    ArrayList<Map> loadExportFile1(Map qIn);
}
