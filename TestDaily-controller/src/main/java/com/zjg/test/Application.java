package com.zjg.test;

import com.zjg.test.remote.core.annotation.RemoteCallScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//zjgtodo 扫描包
@SpringBootApplication(scanBasePackages = {"com.zjg"})
@RemoteCallScan(basePackages = {"com.zjg.test.service.remote"})
public class Application {
    public static void main(String[] args) throws Exception {
    SpringApplication.run(Application.class, args);
    }
}