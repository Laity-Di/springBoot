package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

/**
 * @Author ZhuDi
 * @Time 2019/1/15 17:12
 * @Description
 * @ModifyTime
 */
@Aspect
@Component
public class WebLogAspect {

    private Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(public * com.example.demo.controller..*.*(..))")
    public void webLog(){};

    /**
     * 前置通知：在连接点之前执行的通知
     * @param joinPoint
     * @throws Throwable
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTT  P_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
    }

    /**
     * 后置异常通知
     * @param e
     * @throws Throwable
     */
    @AfterThrowing(pointcut = "webLog()", throwing = "e")
    public void throwServerException(JoinPoint joinPoint, Throwable e) throws Throwable{
        // 获得目标方法名
        String name = joinPoint.getSignature().getName();
        logger.info("<=============" + name + "方法--AOP 后置返回通知=============>");
        logger.info(name + "方法返回参数：" + e.getMessage());
    }

    /**
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     * @param jp
     */
    @After("webLog()")
    public void after(JoinPoint jp){

    }

    /**
     * 环绕通知,环绕增强，相当于MethodInterceptor
     * @param pjp
     * @return
     */
    @Around("webLog()")
    public Object arround(ProceedingJoinPoint pjp) throws Throwable{
        // 获得目标方法名
        String name = pjp.getSignature().getName();
        logger.info("<=============" + name + "方法--AOP 环绕通知=============>");
        long start = System.currentTimeMillis();
        Object result = null;
        result = pjp.proceed();
        long end = System.currentTimeMillis();
        if (logger.isInfoEnabled()) {
            logger.info("around " + pjp + "\tUse time : "
                    + (end - start) + " ms!");
        }
        return result;
    }


}
