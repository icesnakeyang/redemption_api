package cc.redemption_api.adminEnd.maintenance;

import cc.redemption_api.business.admin.maintenance.IAdminMaintenanceBService;
import cc.redemption_api.framework.vo.AdminMaintenanceRequest;
import cc.redemption_api.framework.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/redemption_api/admin/maintenance")
public class AdminMaintenanceController {
    private final IAdminMaintenanceBService iAdminMaintenanceBService;

    public AdminMaintenanceController(IAdminMaintenanceBService iAdminMaintenanceBService) {
        this.iAdminMaintenanceBService = iAdminMaintenanceBService;
    }

    /**
     * 导出所有数据到excel表
     *
     * @param httpServletRequest
     * @return
     */
    @ResponseBody
    @PostMapping("/loadExportData1")
    public Response loadExportData1(HttpServletRequest httpServletRequest) {
        Response response = new Response();
        Map in = new HashMap();
        try {
            String token = httpServletRequest.getHeader("token");
            in.put("token", token);

            Map out = iAdminMaintenanceBService.loadExportData1(in);
            response.setData(out);
        } catch (Exception ex) {
            try {
                response.setCode(Integer.parseInt(ex.getMessage()));
            } catch (Exception ex2) {
                response.setCode(10001);
                log.error("Admin loadExportData1 error:" + ex.getMessage());
            }
        }
        return response;
    }

    /**
     * 查询系统变量设置列表
     *
     * @param httpServletRequest
     * @return
     */
    @ResponseBody
    @PostMapping("/listSetting")
    public Response listSetting(@RequestBody AdminMaintenanceRequest request,
                                HttpServletRequest httpServletRequest) {
        Response response = new Response();
        Map in = new HashMap();
        try {
            String token = httpServletRequest.getHeader("token");
            in.put("token", token);
            in.put("pageIndex", request.getPageIndex());
            in.put("pageSize", request.getPageSize());

            Map out = iAdminMaintenanceBService.listSetting(in);
            response.setData(out);
        } catch (Exception ex) {
            try {
                response.setCode(Integer.parseInt(ex.getMessage()));
            } catch (Exception ex2) {
                response.setCode(10001);
                log.error("Admin listSetting error:" + ex.getMessage());
            }
        }
        return response;
    }

    /**
     * 管理员添加一个系统变量设置
     *
     * @param httpServletRequest
     * @return
     */
    @ResponseBody
    @PostMapping("/createSetting")
    public Response createSetting(@RequestBody AdminMaintenanceRequest request,
                                  HttpServletRequest httpServletRequest) {
        Response response = new Response();
        Map in = new HashMap();
        try {
            String token = httpServletRequest.getHeader("token");
            in.put("token", token);
            in.put("paramName", request.getParamName());
            in.put("paramValue", request.getParamValue());

            iAdminMaintenanceBService.createSetting(in);
        } catch (Exception ex) {
            try {
                response.setCode(Integer.parseInt(ex.getMessage()));
            } catch (Exception ex2) {
                response.setCode(10001);
                log.error("Admin createSetting error:" + ex.getMessage());
            }
        }
        return response;
    }

    /**
     * 管理员修改一个系统变量设置
     *
     * @param httpServletRequest
     * @return
     */
    @ResponseBody
    @PostMapping("/updateSetting")
    public Response updateSetting(@RequestBody AdminMaintenanceRequest request,
                                  HttpServletRequest httpServletRequest) {
        Response response = new Response();
        Map in = new HashMap();
        try {
            String token = httpServletRequest.getHeader("token");
            in.put("token", token);
            in.put("paramName", request.getParamName());
            in.put("paramValue", request.getParamValue());
            in.put("settingId", request.getSettingId());

            iAdminMaintenanceBService.updateSetting(in);
        } catch (Exception ex) {
            try {
                response.setCode(Integer.parseInt(ex.getMessage()));
            } catch (Exception ex2) {
                response.setCode(10001);
                log.error("Admin updateSetting error:" + ex.getMessage());
            }
        }
        return response;
    }

    /**
     * 管理员删除一个系统变量设置
     *
     * @param httpServletRequest
     * @return
     */
    @ResponseBody
    @PostMapping("/deleteSetting")
    public Response deleteSetting(AdminMaintenanceRequest request,
                                  HttpServletRequest httpServletRequest) {
        Response response = new Response();
        Map in = new HashMap();
        try {
            String token = httpServletRequest.getHeader("token");
            in.put("token", token);
            in.put("settingId", request.getSettingId());

            iAdminMaintenanceBService.deleteSetting(in);
        } catch (Exception ex) {
            try {
                response.setCode(Integer.parseInt(ex.getMessage()));
            } catch (Exception ex2) {
                response.setCode(10001);
                log.error("Admin deleteSetting error:" + ex.getMessage());
            }
        }
        return response;
    }

    /**
     * 管理员读取一个系统变量设置
     *
     * @param httpServletRequest
     * @return
     */
    @ResponseBody
    @PostMapping("/getSetting")
    public Response getSetting(@RequestBody AdminMaintenanceRequest request,
                               HttpServletRequest httpServletRequest) {
        Response response = new Response();
        Map in = new HashMap();
        try {
            String token = httpServletRequest.getHeader("token");
            in.put("token", token);
            in.put("settingId", request.getSettingId());

            Map out = iAdminMaintenanceBService.getSetting(in);
            response.setData(out);
        } catch (Exception ex) {
            try {
                response.setCode(Integer.parseInt(ex.getMessage()));
            } catch (Exception ex2) {
                response.setCode(10001);
                log.error("Admin getSetting error:" + ex.getMessage());
            }
        }
        return response;
    }

}
