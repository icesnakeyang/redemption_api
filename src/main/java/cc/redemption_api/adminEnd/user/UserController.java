package cc.redemption_api.adminEnd.user;

import cc.redemption_api.business.admin.user.IAdminUserBService;
import cc.redemption_api.framework.vo.AdminUserRequest;
import cc.redemption_api.framework.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/redemption_api/admin/user")
public class UserController {
    private final IAdminUserBService iAdminUserBService;

    public UserController(IAdminUserBService iAdminUserBService) {
        this.iAdminUserBService = iAdminUserBService;
    }

    /**
     * @param request
     * @param httpServletRequest
     * @return
     */
    @ResponseBody
    @PostMapping("/listUser")
    public Response listUser(@RequestBody AdminUserRequest request,
                             HttpServletRequest httpServletRequest) {
        Response response = new Response();
        Map in = new HashMap();
        try {
            String token = httpServletRequest.getHeader("token");
            in.put("token", token);
            in.put("pageIndex", request.getPageIndex());
            in.put("pageSize", request.getPageSize());

            Map out = iAdminUserBService.listUser(in);
            response.setData(out);
        } catch (Exception ex) {
            try {
                response.setCode(Integer.parseInt(ex.getMessage()));
            } catch (Exception ex2) {
                response.setCode(10001);
                log.error("Admi listUser error:" + ex.getMessage());
            }
        }
        return response;
    }

    /**
     * @param request
     * @param httpServletRequest
     * @return
     */
    @ResponseBody
    @PostMapping("/getUserDetail")
    public Response getUserDetail(@RequestBody AdminUserRequest request,
                             HttpServletRequest httpServletRequest) {
        Response response = new Response();
        Map in = new HashMap();
        try {
            String token = httpServletRequest.getHeader("token");
            in.put("token", token);
            in.put("userId", request.getUserId());

            Map out = iAdminUserBService.getUserDetail(in);
            response.setData(out);
        } catch (Exception ex) {
            try {
                response.setCode(Integer.parseInt(ex.getMessage()));
            } catch (Exception ex2) {
                response.setCode(10001);
                log.error("Admin getUserDetail error:" + ex.getMessage());
            }
        }
        return response;
    }

    /**
     * @param httpServletRequest
     * @return
     */
    @ResponseBody
    @GetMapping("/loadUserStatistic")
    public Response loadUserStatistic(HttpServletRequest httpServletRequest) {
        Response response = new Response();
        Map in = new HashMap();
        try {
            String token = httpServletRequest.getHeader("token");
            in.put("token", token);

            Map out = iAdminUserBService.loadUserStatistic(in);
            response.setData(out);
        } catch (Exception ex) {
            try {
                response.setCode(Integer.parseInt(ex.getMessage()));
            } catch (Exception ex2) {
                response.setCode(10001);
                log.error("Admin loadUserStatistic error:" + ex.getMessage());
            }
        }
        return response;
    }


}
