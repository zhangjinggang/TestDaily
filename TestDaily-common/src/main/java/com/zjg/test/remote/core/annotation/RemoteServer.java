package com.zjg.test.remote.core.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
  * @description: 远程服务的name
  * @author zjg
  * @date 2020/4/23 16:39
  */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RemoteServer {

    @AliasFor(value = "serverName")
    String value() default "";

    @AliasFor(value = "value")
    String serverName() default "";
}
