package tk.youngdk.quartz_demo.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import tk.youngdk.quartz_demo.config.datasource.DataSourceLookupKeyContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import static tk.youngdk.quartz_demo.utils.Utils.getParams;

@Component
@Aspect
@RequiredArgsConstructor
@Slf4j
public class LoggerAspect {

    @Pointcut("execution(* tk.youngdk.quartz_demo.controller.*Controller.*(..))")
    public void loggerPointCut() {
    }

    @Around("loggerPointCut()")
    public Object selectDb(ProceedingJoinPoint joinPoint) throws Throwable {

        try {
            Object result = joinPoint.proceed();
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest(); // request 정보를 가져온다.

            String controllerName = joinPoint.getSignature().getDeclaringType().getSimpleName();


            String methodName = joinPoint.getSignature().getName();

            Map<String, Object> params = new HashMap<>();

            try {
                params.put("controller", controllerName);
                params.put("method", methodName);
                params.put("params", getParams(request));
                params.put("log_time", new Date());
                params.put("request_uri", request.getRequestURI());
                params.put("http_method", request.getMethod());
            } catch (Exception e) {
                log.error("LoggerAspect error", e);
            }
            log.info("params : {}", params); // param에 담긴 정보들을 한번에 로깅한다.

            return result;

        } catch (Throwable throwable) {
            throw throwable;
        }
    }


    @Pointcut("execution(* tk.youngdk.quartz_demo.service.*DowhatService.*(..))")
    public void dowhatPointCut() {
    }

    @Around("dowhatPointCut()")
    public Object changeDowhatDataSource(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("LoggerAspect.changeDowhatDataSource");

        DataSourceLookupKeyContextHolder.changeDowhat();

        Object result = joinPoint.proceed();

        DataSourceLookupKeyContextHolder.changeHotel();

        System.out.println("LoggerAspect.changeDowhatDataSource");
        return result;

    }

}
