package com.tms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Banana {
    private String color;
    private Spider spider;

    @Autowired
    public Banana(Spider spider) {
        this.spider = spider;
    }

    public Spider getSpider() {
        return spider;
    }

    public void setSpider(Spider spider) {
        this.spider = spider;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Banana(String color) {
        this.color = color;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}


