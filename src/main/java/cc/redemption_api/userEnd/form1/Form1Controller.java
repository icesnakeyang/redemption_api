package cc.redemption_api.userEnd.form1;

import cc.redemption_api.business.form1.IForm1BService;
import cc.redemption_api.framework.vo.Form1Request;
import cc.redemption_api.framework.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/redemption_api/form1")
public class Form1Controller {
    private final IForm1BService iForm1BService;

    public Form1Controller(IForm1BService iForm1BService) {
        this.iForm1BService = iForm1BService;
    }

    @ResponseBody
    @PostMapping("/saveForm1")
    public Response saveForm1(@RequestBody Form1Request request) {
        Response response = new Response();
        Map in = new HashMap();
        try {
            in.put("name", request.getName());
            in.put("icNumber1", request.getIcNumber1());
            in.put("icNumber2", request.getIcNumber2());
            in.put("icNumber3", request.getIcNumber3());
            in.put("phoneF1", request.getPhoneF1());
            in.put("phoneF2", request.getPhoneF2());
            in.put("address", request.getAddress());
            in.put("postcode", request.getPostcode());
            in.put("email", request.getEmail());

            iForm1BService.saveForm1(in);
        } catch (Exception ex) {
            try {
                response.setCode(Integer.parseInt(ex.getMessage()));
            } catch (Exception ex2) {
                response.setCode(10001);
                log.error("saveForm1 error:" + ex.getMessage());
            }
        }
        return response;
    }
}
