package cc.redemption_api.adminEnd.survey;

import cc.redemption_api.business.admin.survey.IAdminSurveyBService;
import cc.redemption_api.framework.vo.Response;
import cc.redemption_api.framework.vo.SurveyRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/redemption_api/admin/survey")
public class AdminSurveyController {
    private final IAdminSurveyBService iAdminSurveyBService;

    public AdminSurveyController(IAdminSurveyBService iAdminSurveyBService) {
        this.iAdminSurveyBService = iAdminSurveyBService;
    }

    /**
     * 管理员查询问题库列表
     *
     * @param request
     * @param httpServletRequest
     * @return
     */
    @ResponseBody
    @PostMapping("/listSurvey")
    public Response listSurvey(@RequestBody SurveyRequest request,
                               HttpServletRequest httpServletRequest) {
        Response response = new Response();
        Map in = new HashMap();
        try {
            String token = httpServletRequest.getHeader("token");
            in.put("token", token);
            in.put("pageIndex", request.getPageIndex());
            in.put("pageSize", request.getPageSize());

            Map out = iAdminSurveyBService.listSurvey(in);
            response.setData(out);
        } catch (Exception ex) {
            try {
                response.setCode(Integer.parseInt(ex.getMessage()));
            } catch (Exception ex2) {
                response.setCode(10001);
                log.error("Admin listSurvey error:" + ex.getMessage());
            }
        }
        return response;
    }

    /**
     * 管理员保存一条问题库
     *
     * @param request
     * @param httpServletRequest
     * @return
     */
    @ResponseBody
    @PostMapping("/saveSurvey")
    public Response saveSurvey(@RequestBody SurveyRequest request,
                               HttpServletRequest httpServletRequest) {
        Response response = new Response();
        Map in = new HashMap();
        try {
            String token = httpServletRequest.getHeader("token");
            in.put("token", token);
            in.put("title", request.getTitle());
            in.put("content", request.getContent());

            iAdminSurveyBService.saveSurvey(in);
        } catch (Exception ex) {
            try {
                response.setCode(Integer.parseInt(ex.getMessage()));
            } catch (Exception ex2) {
                response.setCode(10001);
                log.error("Admin saveSurvey error:" + ex.getMessage());
            }
        }
        return response;
    }
}
