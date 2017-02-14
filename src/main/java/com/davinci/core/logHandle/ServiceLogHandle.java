package com.davinci.core.logHandle;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.davinci.core.exception.GeneralException;

/**
 * Created by YoungMan on 2017/2/13.
 */
@Order(2)
@Aspect
@Component
public class ServiceLogHandle {
    private static Logger log = LoggerFactory.getLogger(ServiceLogHandle.class);
    @Pointcut("execution(public * com.davinci.shop..service.*.*(..))")
    public void declareJointPointExpression(){}
    @Before("declareJointPointExpression()")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        String className=joinPoint.getTarget().getClass().getSimpleName();
        log.debug(className+"."+methodName+" 参数是："+Arrays.asList(joinPoint.getArgs()));
    }

    @AfterReturning(value="declareJointPointExpression()",
            returning="result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        String className=joinPoint.getTarget().getClass().getSimpleName();
        log.debug(className+"."+methodName+" 返回值：："+result);
    }

    @AfterThrowing(value="declareJointPointExpression()",
            throwing="e")
    public void afterThrowing(JoinPoint joinPoint, GeneralException e){
        String methodName = joinPoint.getSignature().getName();
        String className=joinPoint.getTarget().getClass().getSimpleName();
        log.debug(className+"."+methodName+" 发生异常：："+e.getMessage());
    }
}
