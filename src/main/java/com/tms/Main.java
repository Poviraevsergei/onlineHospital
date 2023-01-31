package com.tms;

import com.tms.service.DoctorService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        DoctorService doctorService = (DoctorService) context.getBean("doctorService");

        doctorService.firstMethod();
    }
}
