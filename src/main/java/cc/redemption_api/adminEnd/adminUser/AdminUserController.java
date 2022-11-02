package cc.redemption_api.adminEnd.adminUser;

import cc.redemption_api.business.admin.IAdminBService;
import cc.redemption_api.framework.vo.AdminRequest;
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
@RequestMapping("/redemption_api/admin/admin")
public class AdminUserController {
    private final IAdminBService iAdminBService;

    public AdminUserController(IAdminBService iAdminBService) {
        this.iAdminBService = iAdminBService;
    }

    /**
     * 创建一个管理员账号
     *
     * @param request
     * @return
     */
    @ResponseBody
    @PostMapping("/createRootAdmin")
    public Response createRootAdmin(@RequestBody AdminRequest request) {
        Response response = new Response();
        Map in = new HashMap();
        try {
            in.put("loginName", request.getLoginName());
            in.put("password", request.getPassword());
            in.put("roleType", request.getRoleType());

            iAdminBService.createRootAdmin(in);
        } catch (Exception ex) {
            try {
                response.setCode(Integer.parseInt(ex.getMessage()));
            } catch (Exception ex2) {
                response.setCode(10001);
                log.error("admin createRootAdmin error:" + ex.getMessage());
            }
        }
        return response;
    }

    /**
     * 创建一个管理员账号
     *
     * @param request
     * @return
     */
    @ResponseBody
    @PostMapping("/createAdmin")
    public Response createAdmin(@RequestBody AdminRequest request,
                                HttpServletRequest httpServletRequest) {
        Response response = new Response();
        Map in = new HashMap();
        try {
            String token = httpServletRequest.getHeader("token");
            in.put("token", token);
            in.put("loginName", request.getLoginName());
            in.put("password", request.getPassword());
            in.put("roleType", request.getRoleType());

            iAdminBService.createAdmin(in);
        } catch (Exception ex) {
            try {
                response.setCode(Integer.parseInt(ex.getMessage()));
            } catch (Exception ex2) {
                response.setCode(10001);
                log.error("admin createAdmin error:" + ex.getMessage());
            }
        }
        return response;
    }


    /**
     * 管理员登录
     *
     * @param request
     * @return
     */
    @ResponseBody
    @PostMapping("/adminLogin")
    public Response adminLogin(@RequestBody AdminRequest request) {
        Response response = new Response();
        Map in = new HashMap();
        try {
            in.put("loginName", request.getLoginName());
            in.put("password", request.getPassword());

            Map out = iAdminBService.adminLogin(in);
            response.setData(out);
        } catch (Exception ex) {
            try {
                response.setCode(Integer.parseInt(ex.getMessage()));
            } catch (Exception ex2) {
                response.setCode(10001);
                log.error("admin adminLogin error:" + ex.getMessage());
            }
        }
        return response;
    }

    /**
     * 管理员登录by token
     *
     * @param httpServletRequest
     * @return
     */
    @ResponseBody
    @GetMapping("/adminLoginByToken")
    public Response adminLoginByToken(HttpServletRequest httpServletRequest) {
        Response response = new Response();
        Map in = new HashMap();
        try {
            String token = httpServletRequest.getHeader("token");
            in.put("token", token);

            Map out = iAdminBService.adminLoginByToken(in);
            response.setData(out);
        } catch (Exception ex) {
            try {
                response.setCode(Integer.parseInt(ex.getMessage()));
            } catch (Exception ex2) {
                response.setCode(10001);
                log.error("admin adminLoginByToken error:" + ex.getMessage());
            }
        }
        return response;
    }

    /**
     * 管理员查看所有管理员用户列表
     *
     * @param httpServletRequest
     * @return
     */
    @ResponseBody
    @PostMapping("/listAdminUser")
    public Response listAdminUser(@RequestBody AdminUserRequest request,
                                  HttpServletRequest httpServletRequest) {
        Response response = new Response();
        Map in = new HashMap();
        try {
            String token = httpServletRequest.getHeader("token");
            in.put("token", token);
            in.put("pageIndex", request.getPageIndex());
            in.put("pageSize", request.getPageSize());

            Map out = iAdminBService.listAdminUser(in);
            response.setData(out);
        } catch (Exception ex) {
            try {
                response.setCode(Integer.parseInt(ex.getMessage()));
            } catch (Exception ex2) {
                response.setCode(10001);
                log.error("admin listAdminUser error:" + ex.getMessage());
            }
        }
        return response;
    }
}
