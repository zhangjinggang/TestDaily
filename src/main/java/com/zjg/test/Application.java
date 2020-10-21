package com.zjg.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.zjg.test"})
public class Application {
    public static void main(String[] args) throws Exception {
    SpringApplication.run(Application.class, args);
    }
}