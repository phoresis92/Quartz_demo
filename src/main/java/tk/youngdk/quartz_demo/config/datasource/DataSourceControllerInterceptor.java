package tk.youngdk.quartz_demo.config.datasource;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class DataSourceControllerInterceptor extends HandlerInterceptorAdapter {

    private static final String DATA_SOURCE_TYPE_HEADER_NAME = "companySeq";



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("DataSourceControllerInterceptor.preHandle");

//        String dataSourceTypeName = request.getHeader(DATA_SOURCE_TYPE_HEADER_NAME);
        String companySeq = request.getParameter(DATA_SOURCE_TYPE_HEADER_NAME);
        System.out.println("companySeq = " + companySeq);
        System.out.println("companySeq = " + companySeq);

        if (companySeq.isEmpty()) {
            throw new IllegalArgumentException("Request header [" + DATA_SOURCE_TYPE_HEADER_NAME + "] is not exist");
        }

        DataSourceType target = null;
        switch (companySeq) {
            case "100":
                target = DataSourceType.RAMADA;
                break;
            case "101":
                target = DataSourceType.STJOHNS;
                break;
        }

        if (target == null) {
            throw new IllegalArgumentException("");
        }

        DataSourceLookupKeyContextHolder.set(target);

        return super.preHandle(request, response, handler);
    }
}
