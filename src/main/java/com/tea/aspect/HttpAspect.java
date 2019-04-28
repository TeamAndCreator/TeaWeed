package com.tea.aspect;


import com.tea.entity.Log;
import com.tea.service.LogService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


@Aspect
@Component
public class HttpAspect {

    @Autowired
    private LogService logService;

    private static final Logger LOGGER = LogManager.getLogger(HttpAspect.class);


    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("execution(public * com.tea.controller.*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        Log log = new Log();
        log.setOptUrl(request.getRequestURI());
        log.setOptUser((String) request.getSession().getAttribute("username"));
        log.setClassMethod(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.setOptIp(request.getRemoteAddr());
        log.setRequestParam(Arrays.toString(joinPoint.getArgs()));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strTime = sdf.format(new Date());
        log.setStartTime(strTime);
        logService.save(log);
        LOGGER.info(log.toString());

    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfter(Object object) {

        LOGGER.info("response={}",object);
    }
}




