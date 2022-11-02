package cc.redemption_api.adminEnd.maintenance;

import cc.redemption_api.business.admin.maintenance.IAdminMaintenanceBService;
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
}
