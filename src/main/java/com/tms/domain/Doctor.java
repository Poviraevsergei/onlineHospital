package com.tms.domain;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Doctor {
    private String name;
    private static final Logger log = Logger.getLogger(Doctor.class);

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                '}';
    }
}
