package com.iqmsoft.boot.mybatis.monitor;

import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@CommonsLog
@Aspect
@Component
public class PerformanceMonitor {

    @Pointcut("execution(public * com.iqmsoft.boot.mybatis.web.controller..*(..))")
    private void controllerLayer() {
    }

    /**
     * Monitor the elapsed time of method on controller layer, in
     * order to detect performance problems as soon as possible.
     * If elapsed time > 1 s, log it as an error. Otherwise, log it
     * as an info.
     */
    @Around("controllerLayer()")
    public Object monitorElapsedTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // Timing the method in controller layer
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();

        // Log the elapsed time
        double elapsedTime = stopWatch.getTime() / 1000.0;
        Signature signature = proceedingJoinPoint.getSignature();
        String infoString = "[" + signature.toShortString() + "][Elapsed time: " + elapsedTime + " s]";
        if (elapsedTime > 1) {
            log.error(infoString + "[Note that it's time consuming!]");
        } else {
            log.info(infoString);
        }

        // Return the result
        return result;
    }

}
