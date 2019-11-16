package com.gradle.demo.aop;

import com.gradle.demo.common.PrintLogAnn;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Slf4j
@Aspect
public class ControllerLogAspect {

    @Pointcut("execution(* com.gradle.demo.controller.*.*(..))")
    public void log() {
    }

    @Around("log()")
    public Object doAround(ProceedingJoinPoint jp) {

        Signature signature = jp.getSignature();
        Object[] args = jp.getArgs();
        Object object = null;
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        boolean printLog = true;
        boolean printResultLog = false;
        if (null != method && method.isAnnotationPresent(PrintLogAnn.class)) {
            PrintLogAnn logAnn = method.getAnnotation(PrintLogAnn.class);
            printLog = logAnn.printLog();
            printResultLog = logAnn.printReturnLog();
        }
        try {
            object = jp.proceed();
            if (!printLog) {
                return object;
            }
            if (printResultLog) {
                log.info("### method {}\n\targs {}\n\treturn value{}", signature, args, object);
            } else {
                log.info("### method {}\n\targs {}", signature, args);
            }
        } catch (Exception e) {
            log.error("### method{}\n\targs {}\n\terror {}", signature, args, e);
            throw new RuntimeException(e.getMessage());
        } catch (Throwable e) {
            log.error("### method{}\n\targs {}\n\terror {}", signature, args, e);
            throw new RuntimeException(e.getMessage());
        }
        return object;
    }
}
