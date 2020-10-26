package tk.youngdk.quartz_demo.utils;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class Utils {
    /**
     * request 에 담긴 정보를 JSONObject 형태로 반환한다.
     * @param request
     * @return
     */
    public static JSONObject getParams (HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        Enumeration<String> params = request.getParameterNames();
        while (params.hasMoreElements()) {
            String param = params.nextElement();
            String replaceParam = param.replaceAll("\\.", "-");
            jsonObject.put(replaceParam, request.getParameter(param));
        }
        return jsonObject;
    }
}
