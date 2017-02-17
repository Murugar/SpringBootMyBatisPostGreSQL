package com.iqmsoft.boot.mybatis.monitor;

import lombok.extern.apachecommons.CommonsLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.iqmsoft.boot.mybatis.web.exception.ServerInternalErrorException;

import java.util.Arrays;


@CommonsLog
@Aspect
@Component
public class ServiceMonitor {

   
    @Pointcut("execution(* com.iqmsoft.boot.mybatis.service..*(..))")
    private void serviceLayer() {
    }

  
    @AfterThrowing(pointcut = "com.iqmsoft.boot.mybatis.monitor.ServiceMonitor.serviceLayer()", throwing = "e")
    public void monitorException(JoinPoint joinPoint, Throwable e) {
        // Log the situation where exception happened
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        log.error("[" + signature.toShortString() + "]" + Arrays.toString(args) + "[" + e.toString() + "]");

        // Throw a new server internal error exception
        throw new ServerInternalErrorException();
    }

}
