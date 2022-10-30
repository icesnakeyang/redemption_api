package cc.redemption_api.business.form1;

import java.util.Map;

public interface IForm1BService {
    void saveForm1(Map in) throws Exception;

    /**
     * 读取要调查的问题列表
     *
     * @param in
     * @return
     * @throws Exception
     */
    Map listSurveyLib(Map in) throws Exception;
}
