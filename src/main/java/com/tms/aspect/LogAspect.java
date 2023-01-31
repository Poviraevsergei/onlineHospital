package com.tms.aspect;

import com.tms.service.DoctorService;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {

    private final Logger log = Logger.getLogger(this.getClass());

    @Before("within(com.tms.service.DoctorService)")
    public void logBeforeMethod(JoinPoint joinPoint) {
        log.info("THIS LOG BEFORE METHOD!" + joinPoint.getSignature());
    }

    @After("within(com.tms.service.DoctorService)")
    public void logAfterMethod(JoinPoint joinPoint) {
        log.info("THIS LOG AFTER METHOD!" );
    }

    @AfterReturning("within(com.tms.service.DoctorService)")
    public void logAfterReturningMethod() {
        log.info("THIS LOG AFTER RETURNING METHOD!");
    }

    @AfterThrowing("within(com.tms.service.DoctorService)")
    public void logAfterThrowingMethod() {
        log.info("THIS LOG AFTER Throwing METHOD!");
    }

    @Around("@annotation(com.tms.annotations.CheckTimeAnnotation)")
    public void logAfterAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        LocalTime start = LocalTime.now();
        System.out.println("Timer start...");
        joinPoint.proceed();
        LocalTime end = LocalTime.now();
        System.out.println("Timer end...");
        log.info(end.getNano() - start.getNano());
    }
}