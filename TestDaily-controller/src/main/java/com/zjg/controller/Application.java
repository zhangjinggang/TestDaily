package com.zjg.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//zjgtodo 扫描包
@SpringBootApplication(scanBasePackages = {"com.zjg.controller"})
public class Application {
    public static void main(String[] args) throws Exception {
    SpringApplication.run(Application.class, args);
    }
}